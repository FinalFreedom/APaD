package arraySorter;


/**
 * The implementation of selection sort for an array of comparable elements
 * 
 * @author Oliver Sheard
 * @version October 2017
 */
public class SelectionSort<T extends Comparable<? super T>> extends ArraySortTool<T>
{
    public void sort(T[] array)
    {
        for(int i = array.length-1; i>0;i--)
        {
        	int max = 0;
        	T current = array[0];
        	for(int k=0; k<=i; k++)
        	{
        		if(array[k].compareTo(current)>0)
        		{
        			max = k;
        			current=array[k];
        		}
        	}
        	T temp = array[i];
        	array[i]=array[max];
        	array[max] = temp;
        }
    }
} 
