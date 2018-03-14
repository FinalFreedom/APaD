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
			if(getNeighbours(node).size()==0)
			{
				sortNode(node);
				break;
			}
		}
		return traversal;
	}
	private void sortNode(T node) throws GraphError
	{
		traversal.add(node);
		graphCopy.remove(node);
		//A graphCopy with 0 remaining nodes will simply never run this forEach loop
		for(T remaining: graphCopy)
		{
			if(getNeighbours(remaining).size()==0)
			{
				sortNode(remaining);
			}
		}
	}
}