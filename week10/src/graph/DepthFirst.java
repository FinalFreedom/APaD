package graph;

import java.util.List;
import java.util.ArrayList;

public class DepthFirst<T> extends AdjacencyGraph<T> implements Traversal<T> {
	private List<T> nodes, traversal = new ArrayList<T>();
	private int size = getNodes().size();
	
	@Override
	public List<T> traverse() throws GraphError
	{
		for(int i=0; i<size;i++)
		{
			if(traversal.size() < size)
			{
				T startNode = (T) getNodes().toArray()[i];
				if(!traversal.contains(startNode))
				{
					RecursiveTraversal(startNode);
				}
			}
			else break;
		}
		return null;
	}
	
	private void RecursiveTraversal(T node) throws GraphError
	{
		traversal.add(node);
		nodes.add(node);
		
		T[] neighbours = (T[])getNeighbours(node).toArray();
		for(int i=0;i<neighbours.length;i++)
		{
			if(neighbours[i]!=null&&!traversal.contains(neighbours[i]))
			{
				RecursiveTraversal(neighbours[i]);
			}
		}
	}

}
