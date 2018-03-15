package graph;

import java.util.List;
import java.util.Set;

public class ReferenceCount<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{
	private List<T> traversal;
	private Set<T> graphCopy = getNodes();
	@Override
	public List<T> getSort() throws GraphError
	{
		for(T node: graphCopy)
		{
			sortNode(node);
			break;
		}
		return traversal;
	}
	private void sortNode(T node) throws GraphError
	{
		traversal.add(node);
		graphCopy.remove(node);
		if(graphCopy.size()>1)
		{
			for(T remaining: graphCopy)
			{
				if(getNeighbours(remaining).size()==0)
				{
					sortNode(remaining);
					break;
				}
			}
		}
		
	}
}