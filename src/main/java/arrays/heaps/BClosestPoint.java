package arrays.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105

Input Format
The argument given is list A and an integer B.
Output Format
Return the B closest points to the origin (0, 0) in any order.

Example Input
Input 1:

 A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
 Example Output
Output 1:

 [ [-2, 2] ]
Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

Input 2:

 A = [
       [1, -1],
       [2, -1]
     ]
 B = 1


Example Output
Output 2:

 [ [1, -1] ]
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */
public class BClosestPoint {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,3)));
        A.add(new ArrayList<>(Arrays.asList(-2,2)));
        int B =1;
        System.out.println(solve(A,B));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
        // this is custom comparator for comparing points,
        // for each point distance is calculated from (0,0)
        // then both distances are compared. whichever is smaller that point is add as root of minPQ.
        Comparator<Point> distanceComparator = new Comparator<Point>() {
            @Override
            public int compare(Point s1, Point s2) {
                float xdist = (float) Math.pow((s1.x), 2);
                float ydist = (float) Math.pow((s1.y), 2);
                int distPoint1 = (int) (xdist + ydist); // distance of first point with origin
                xdist = (float) Math.pow((s2.x), 2);
                ydist = (float) Math.pow((s2.y), 2);
                int distPoint2 = (int) (xdist + ydist);  // distance of second point with origin
                return  (distPoint1 - distPoint2);
            }
        };

        PriorityQueue<Point> minDistancePq = new PriorityQueue<>(distanceComparator);
        for (ArrayList<Integer> currPoint : A) {
            minDistancePq.add(new Point(currPoint.get(0), currPoint.get(1)));
        }
        for (int i = 0; i < B; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            Point tmpPoint = minDistancePq.poll();
            tmp.add(tmpPoint.x);
            tmp.add(tmpPoint.y);
            retVal.add(tmp);
        }
        return retVal;
    }
}

