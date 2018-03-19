package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public class ReferenceCount<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{
	private Stack<T> traversal = new Stack<T>();
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
		//Initialise the graph onto the HashMap
		for(T node: getNodes())
		{
			countTable.put(node,0);
		}
		//Update the HashMap to have data of how many neighbours each node has
		for(T node:getNodes())
		{
			for(T neighbour:getNeighbours(node))
			{
				int i = countTable.get(neighbour);
				countTable.put(neighbour, ++i);
			}
		}
	}

	private void sort() throws GraphError
	{
		T zeroNode; //Create a local variable for the node with 0 neighbours
		while((zeroNode = nextReferenceZeroNode())!=null)
		{
			for(T neighbour:getNeighbours(zeroNode))
			{
				Integer count = countTable.get(neighbour);
				if(count!=null)
				{
					countTable.put(neighbour, count-1);
				}
				countTable.put(zeroNode, count-1);
			}
			countTable.remove(zeroNode);
			traversal.add(zeroNode);
		}
	}
	
	private T nextReferenceZeroNode()
	{
		for(Entry<T, Integer> node:countTable.entrySet())
		{
			if(node.getValue()==0)
			{
				return (T) node.getKey();
			}
		}
		return null;
	}
}