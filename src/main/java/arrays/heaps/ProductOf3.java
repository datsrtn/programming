package arrays.heaps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Description
 * Given an integer array A of size N.
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 0 <= A[i] <= 103
 *
 * Input Format
 * First and only argument is an integer array A.
 * Output Format
 * Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
 *
 * Example Input
 * A = [1, 2, 3, 4, 5]
 * Example Output
 * [-1, -1, 6, 24, 60]
 * Explanation
 *  For i = 1, ans = -1
 *  For i = 2, ans = -1
 *  For i = 3, ans = 1 * 2 * 3 = 6
 *  For i = 4, ans = 2 * 3 * 4 = 24
 *  For i = 5, ans = 3 * 4 * 5 = 60
 *
 *  So, the output is [-1, -1, 6, 24, 60].
 *
 *  Example Input
 *   A = [10, 2, 13, 4]
 *  Example Output
 *  [-1, -1, 260, 520]
 *  Explanation
 *  For i = 1, ans = -1
 *  For i = 2, ans = -1
 *  For i = 3, ans = 10 * 2 * 13 = 260
 *  For i = 4, ans = 10 * 13 * 4 = 520
 *
 *  So, the output is [-1, -1, 260, 520].
 *
 *
 */
public class ProductOf3 {
    public static void main(String[] args) {
     int []A = {1,2,3,4,5};
        System.out.println(
                Arrays.stream(solve(A))
                        .boxed()
                        .collect(Collectors.toList())
        );
     }

    public static int[] solve(int [] A) {
        // brute force way would be from i = 0 to current index get 3 maximum number and do multiplication
        // optimum way is use heap, implemented as PriorityQueue

        int [] retVal = new int[A.length];
        // reverse order makes sure that the value are stored descending ,ie pq[0] -> max value pq[1] -> second max etc
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]); // adding value to the priority queues, pq automatically will arrange this as per max values
            if(i < 2) {
                retVal[i] = -1; // first 2 values are -1, as we need product of 3 max numbers
            } else {
                int val1 = pq.poll();
                int val2 = pq.poll();
                int val3 = pq.poll();
                Long x = Long.valueOf(val1  * val2  * val3);
                retVal[i] = x.intValue();
                // we need previous values too, so push old values back to pq, ie max heap
                pq.add(val1);
                pq.add(val2);
                pq.add(val3);
            }
        }
        return retVal;
    }
}
