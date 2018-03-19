package intArrays;

import java.util.Arrays; // in order to be able to use the fill(...) method
/**
 * An extension of RandomCount
 * 
 * @author Hugh Osborne
 * @version September 2017
 */
public class CleverRandomListing extends RandomListing
{
    /**
     * Constructor
     */
    public CleverRandomListing(int size) {
        super(size);
    }
    
    /**
     * Randomise the array
     */
    protected void randomise()
    {
        for(int p=0;p<getArray().length;p++)
        {
            int tempIndex = getRandomIndex();
            int tempValue = getArray()[p];
            getArray()[p] = getArray()[tempIndex];
            getArray()[tempIndex] = tempValue;
        }
    }
    public static void main(String[] args) {
    	RandomListing count = new CleverRandomListing(1000000);
    	System.out.println(Arrays.toString(count.getArray()));
    }

} // End of class SimpleRandomCount