package arrays.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KPathsApart {
    public static void main(String[] args) {
        ArrayList<Integer> retVal =  new ArrayList<>();


        int [] a = { 25, 16, 11, 31, 28, 20, 3, 8 };
        ArrayList<Integer> A =  new ArrayList<>(Arrays.stream(a).boxed().toList());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int B=6;

        for(int i=0; i<A.size();i++) {
            if(i <= B) {
                minPq.add(A.get(i));
            } else {
                retVal.add(minPq.poll());
               
                     }
        }
        while(!minPq.isEmpty()) {
            retVal.add(minPq.poll());
        }
        System.out.println(retVal);

    }
    public void add(int a , int b) {

    }
    public void add(float a , float b) {

    }
}
