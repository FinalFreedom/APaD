package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ReferenceCount<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{
	private List<T> traversal = null;
	private Set<T> graphCopy = getNodes();
	private HashMap<T,Integer> countTable = new HashMap<T,Integer>();
	@Override
	public List<T> getSort() throws GraphError
	{
		setup();
		sort();
		return traversal;
	}
	
	private void setup() throws GraphError
	{
		initialize();
		countRefrences();
	}
	
	private void initialize()
	{
		for(T node: getNodes())
		{
			countTable.put(node,0);
		}
	}
	
	private void countRefrences() throws GraphError
	{
		for(T node:getNodes())
		{
			for(T neighbour:getNeighbours(node))
			{
				int i = countTable.get(neighbour);
				countTable.put(neighbour, ++i);
			}
		}
	}
	private void sort()
	{
		while(1==1)
		{
			//Woo
		}
	}
	
	private void nextReferenceZeroNode()//WORK HERE DUMBASS
	
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