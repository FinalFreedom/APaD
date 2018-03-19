package arraySorter;

/**
 * The implementation of the quick sort method for an array of comparable elements
 * 
 * @author Oliver Sheard
 * @version October 2017
 */
public class QuickSort<T extends Comparable<? super T>> extends ArraySortTool<T>
{
    public void sort(T[] array)
    {
    	//Initiate quick sort with full array
    	quicksort(array,0,array.length-1);
    }






    /**
     * Performs the quick sort approach to organising an array
     * 
     * @param array Array segment to be sorted (Includes full array)
     * @param low Lowest index value of the section being sorted
     * @param high Highest index value of the section being sorted
     */
    private void quicksort(T[] array, int low, int high)
    {
    	//Selects first element in the array to compare with all others
    	T compare = array[low];
    	int pivotIndex = low;
    	for(int i= low+1; i<=high;i++)
       	{
    		//Searches for elements smaller than first element
       		if(compare.compareTo(array[i])<=0)
       		{
       			//Swaps immediate neighbouring elements while shuffles
				//elements that are further from the pivot index to an
				//appropriate position
       			if(pivotIndex+1!=i)
       			{
       				swapElements(array,pivotIndex,pivotIndex+1);
       			}
       			swapElements(array,pivotIndex,i);
       			//Comparison element has moved up 1 index position,
//updates accordingly
       			pivotIndex++;
       		}
       	}
    	//No need to sort arrays of length 1
    	if(pivotIndex-low>1)
    	{
    		quicksort(array,low,pivotIndex-1);
    	}
    	if(high-pivotIndex>1)
    	{
    		quicksort(array,pivotIndex+1,high);
    	}
    	
    }

    /**
     * @param array Array that needs elements swapping
     * @param index1 Position of the first value to be swapped
     * @param index2 Position of the second value to be swapped
     */
    private void swapElements(T[] array, int index1, int index2)
    {
    	T temp = array[index1];
    	array[index1]=array[index2];
    	array[index2]=temp;
    }
}
