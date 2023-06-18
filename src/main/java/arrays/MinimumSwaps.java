package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
 It is allowed to swap any two elements (not necessarily consecutive).
Find the minimum number of swaps required to sort the array in ascending order.
input  A = [1, 2, 3, 4, 0]  -> output 4
 If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
 You cannot sort it with lesser swaps.
adding temp commit for, eclipse
*/
public class MinimumSwaps {
    public static void main(String[] args) {
        ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(1,2,3,4,0));
        int minIndex = 0;
        int maxIndex = A.size();
        int retVal = 0;
        while(minIndex<maxIndex) {
            if(A.get(minIndex) == minIndex)
                minIndex++;
            else {
                Collections.swap(A,minIndex, A.get(minIndex));
                retVal++;
            }
        }
        System.out.println(retVal);
    }

}

