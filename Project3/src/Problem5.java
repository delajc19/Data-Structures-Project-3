/**
 * Joseph de la Viesca
 * CSC 201
 * Project 3, Question 5
 * 4/25/22
 */

import java.util.Hashtable;
import java.lang.Math;

public class Problem5 {
    /**
     * Finds the number of distinct values in an array of integers
     * @param array
     * @return
     */
    public static int DistinctValues(int[] array){
        //Initialize distinct value counter as the length of the array
        int ctr = array.length;
        //Instantiate empty hashtable
        Hashtable<Integer, Boolean> htable = new Hashtable<Integer, Boolean>();
        for(int i = 0; i < array.length; i++){
            //If the hashtable contains the absolute value of the current element, decrement the distinct value counter
            if(htable.containsKey(Math.abs(array[i]))){
                ctr--;
            }
            //Insert current element into the hashtable
            htable.put(Math.abs(array[i]),true);
        }
        //Return distinct value counter
        return ctr;
    }
}
