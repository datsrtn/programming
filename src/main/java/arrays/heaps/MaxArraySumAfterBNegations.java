package arrays.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Problem Description
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
 *
 * You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 *
 * Problem Constraints
 * 1 <= length of the array <= 5*105
 * 1 <= B <= 5 * 106
 * -100 <= A[i] <= 100
 *
 * Input Format
 * The first argument given is an integer array A.
 * The second argument given is an integer B.
 *
 *
 * Output Format
 * Return an integer denoting the maximum array sum after B modifications.
 *
 * Example Input
 * Input 1:
 *  A = [24, -68, -29, -9, 84]
 *  B = 4
 * Example Output
 * Output 1:  196
 *
 * Example Explanation
 * Final array after B modifications = [24, 68, 29, -9, 84]
 *
 * Input 2:
 *  A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 *  B = 10
 * Output 2:   362
 * Example Explanation
 * Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */


public class MaxArraySumAfterBNegations {
    public static void main(String[] args) {
        int [] A = {24, -68, -29, -9, 84};
        System.out.println(
                solution(A,4)
        );

    }
    static int solution (int [] A, int B) {
        int retVal=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //add values to priority queue method 1
        /*for(int i=0;i < A.length;i++) {
            pq.add(A[i]);
        }*/

        //add values to priority queue method 2
        pq.addAll(
                Arrays.stream(A)
                        .boxed()
                        .collect(Collectors.toList())
        );

        for(int i=0; i < B; i++){
            int x = pq.poll(); // get the minimum value negate it.
            x= x*-1;
            pq.add(x); // add back to min heap
        }
        for(int currInt : pq) {
            retVal += currInt;
        }
        return retVal;
    }
}
