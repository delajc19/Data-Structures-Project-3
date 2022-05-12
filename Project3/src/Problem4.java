/**
 * Joseph de la Viesca
 * CSC 201
 * Project 3, Question 4
 * 4/25/22
 */

import java.util.Hashtable;

public class Problem4 {
    /**
     * Finds two integers in an array that add to a target sum
     * @param target target sum
     * @param array array of integers
     */
    public static void findSumPair(int target, int[] array){
        //instantiate empty hash table
        Hashtable<Integer, Boolean> htable = new Hashtable<Integer, Boolean>();
        for(int i = 0; i < array.length; i++){
            //check if the hashtable contains the difference between the target and each element in the array
            if(htable.containsKey(target - array[i])){
                //Print the pair if found
                System.out.printf("Pair found: %d, %d\n", target - array[i], array[i]);
                return;
            }
            //Insert an element into the hashtable
            htable.put(array[i], true);
        }

        //Print a "not found" statement if the pair is not found
        System.out.println("Pair not found.");
    }
}
