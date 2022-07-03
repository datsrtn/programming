package arrays.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
 * In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
 *
 * Find the maximum number of chocolates that the kid can eat in A units of time.
 *
 * NOTE:
 *
 * floor() function returns the largest integer less than or equal to a given number.
 * Return your answer modulo 109+7
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= B[i] <= INT_MAX
 * 0 <= A <= 105
 *
 *
 * Input Format
 * The first argument is an integer A.
 * The second argument is an integer array B of size N.
 *
 * Output Format
 * Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
 *
 *
 * Example Input
 * Input:
 *  A = 3
 *  B = [6, 5]
 *
 * Example Output
 * Output :
 * 14
 * Example Explanation
 * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
 * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
 * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
 * so, total number of chocolates eaten are 6 + 5 + 3 = 14
 *
 * Input:
 * A = 5
 * b = [2, 4, 6, 8, 10]
 * Example Output
 * 33
 *
 * Maximum number of chocolates that can be eaten is 33.
 *
 */
public class MagicianAndChocolate {
    public static void main(String[] args) {

        //int [] B = { 2, 4, 6, 8, 10};
        int [] B = {2147483647, 2000000014, 2147483647};
        int A =10;

        System.out.println(
                solution(A,B)
        );
    }

    public static int solution(int A, int []B) {
        PriorityQueue<Integer> maxPq =  new PriorityQueue<Integer>(Collections.reverseOrder());
        maxPq.addAll(Arrays.stream(B).boxed().toList());
        int retVal=0;
        for(int i=0;i<A;i++) {
            int tmp = maxPq.poll();
            retVal=(retVal + (tmp%1000000007))%1000000007; // for large integer this is essential
            maxPq.add((int) Math.floor(tmp/2));
        }
        return retVal;

    }
}
