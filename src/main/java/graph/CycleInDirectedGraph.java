package graph;

import java.util.ArrayList;
import java.util.HashMap;

/*
Problem Description
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.
 */
public class CycleInDirectedGraph {
    static int [] visited;
    static int [] path;
    static HashMap<Integer, ArrayList<Integer>> adjMatrix = null;

    static int endNode = 0;
    public static void main(String[] args) {
        int A = 5;
        int[][]  B = {  {1, 2},
                        {4, 1},
                        {2, 4},
                        {3, 4},
                        {5, 2},
                        {1, 3}
                    };
        System.out.println(solve(A,B));
    }
    public static int solve(int A, int[][] B) {
        visited = new int[A];
        path = new int[A];
        endNode = A;
        populateAdjmatrix(B);
        for(int i=1; i<=A; i++) {
            if(visited[i-1] == 0 && dfs(i) == 1) return 1;
        }
        return  0;
    }

    static void populateAdjmatrix(int[][] B) {
        adjMatrix = new HashMap<>();
        for (int[] ints : B) {
            if (adjMatrix.containsKey(ints[0])) {
                adjMatrix.get(ints[0]).add(ints[1]);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(ints[1]);
                adjMatrix.put(ints[0], tmp);
            }
        }
    }
    static int dfs(int u) {
        visited[u - 1] = 1;
        path[u-1] =1;

        if(adjMatrix.containsKey(u) ){
            for (Integer i : adjMatrix.get(u)) {
                if(path[i-1] == 1) return 1;
                if (visited[i - 1] == 0 && dfs(i) ==1) return 1;
            }
        }
        path[u-1] = 0;
        return 0;
    }
}
