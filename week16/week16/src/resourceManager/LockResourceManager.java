package resourceManager;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockResourceManager extends BasicResourceManager {
	final Lock resourceLock = new ReentrantLock();
	final Condition[] conditions = new Condition[NO_OF_PRIORITIES];
	final Condition inUse = resourceLock.newCondition();
	final Condition notInUse = resourceLock.newCondition();
	boolean resourceLocked = false;

	public LockResourceManager(Resource resource, int maxUses) {
		super(resource, maxUses);
		for(int i=0;i<NO_OF_PRIORITIES;i++)
		{
			conditions[i]=resourceLock.newCondition();
		}
	}

	@Override
	public void requestResource(int priority) throws ResourceError {
		resourceLock.lock();
		try
		{
			if(resourceLocked)
			{
				increaseNumberWaiting(priority);
				conditions[priority].await();
			}
			resourceLocked = true;
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			resourceLock.unlock();
		}
	}

	@Override
	public int releaseResource() throws ResourceError {
		int priority = NONE_WAITING;
		resourceLock.lock();
		try
		{
			for(int i = NO_OF_PRIORITIES-1;i>0;i--)
			{
				if(getNumberWaiting(i)>0)
				{
					priority = i;
					break;
				}
			}
			resourceLocked = false;
			if(priority != NONE_WAITING)
			{
				decreaseNumberWaiting(priority);
				conditions[priority].signal();
			}
			return priority;
		}
		finally
		{
			resourceLock.unlock();
		}
		
	}
}
