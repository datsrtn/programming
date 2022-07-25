package arrays.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int B = 3;

        System.out.println(solve(A, B));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
        ArrayList<Point> allPoints = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                allPoints.add(new Point(A.get(i), A.get(j)));
            }
        }

       /* Comparator<Point> fractionValueComparator = new Comparator<Point>() {
            @Override
            public int compare(Point s1, Point s2) {
                float fractVal1 =  (float)s1.x/s1.y;
                float fractVal2 =  (float)s2.x/s2.y;
                float diff =  fractVal1-fractVal2;
                return Math.round(diff);
            }
        };*/
        PriorityQueue<Point> minFractionValPq = new PriorityQueue<>();
        for(Point currPoint : allPoints) {
            minFractionValPq.add(currPoint);
        }
        Point result = new Point(0,0);
        for (int i = 0; i < B; i++) {
            result = minFractionValPq.poll();

        }
        System.out.println(result.x +":"+ result.y);
        return retVal;
    }

}
