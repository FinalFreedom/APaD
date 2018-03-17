package resourceManager;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockResourceManager extends BasicResourceManager {
	Lock lock;
	Condition notFull, notEmpty;
	private boolean locked = false;

	public LockResourceManager(Resource resource, int maxUses) {
		super(resource, maxUses);
		
	}

	@Override
	public void requestResource(int priority) throws ResourceError {
		if(locked)
		{
			super.increaseNumberWaiting(priority);
		}
		else
		{
			
		}
	}

	@Override
	public int releaseResource() throws ResourceError {
		if(nextProcess()==(Integer) null)
		{
			return super.NONE_WAITING;
		}
		else
		{
			return 0;
		}
	}
	private int nextProcess()
	{
		for(int i = super.NO_OF_PRIORITIES;i>=0;i--)
		{
			if(super.getNumberWaiting(i)>0)
			{
				return super.getNumberWaiting(i);
			}
		}
		locked = false;
		return (Integer) null;
	}
}
