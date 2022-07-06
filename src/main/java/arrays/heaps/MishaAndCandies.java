package arrays.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Misha loves eating candies. She has been given N boxes of Candies.

She decides that every time she will choose a box having the minimum number of candies,
eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box.

 Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).

NOTE 2: The same box will not be chosen again.


 A = [3, 2, 3]
 [4 ,3]
 B = 4
 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 She will not eat from the 3rd box as now it has candies greater than B.
 So the number of candies Misha eat is 2.

 */
public class MishaAndCandies {
    public static void main(String[] args) {

        //int [] B = { 2, 4, 6, 8, 10};
        //int [] A = {3, 2, 3};
        int[] A = {705};
        int B = 805;

        System.out.println(
                solution(A, B)
        );
    }

    public static int solution(int[] A, int B) {
        PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();
        minPq.addAll(Arrays.stream(A).boxed().toList());
        int candiesAte = 0;
        while (minPq.peek() <= B  ) {
            int currBox = minPq.poll();
            int tmp = (int) Math.floor(currBox / 2);
            candiesAte += tmp;
            if(minPq.size()==0)
                break;
            minPq.add(minPq.poll() + currBox - tmp);
        }

        return candiesAte;

}
}
