package resourceManager;

public class LockResourceManager extends BasicResourceManager {

	public LockResourceManager(Resource resource, int maxUses) {
		super(resource, maxUses);
	}

	@Override
	public void requestResource(int priority) throws ResourceError {
	}

	@Override
	public int releaseResource() throws ResourceError {
		return 0;
	}
}
