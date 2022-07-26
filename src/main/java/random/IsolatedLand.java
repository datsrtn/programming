package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsolatedLand {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point tmp = (Point) obj;
            if (this.x == tmp.x && this.y == tmp.y)
                return true;
            return false;
        }
    }

    public static void main(String[] args) {


        List<Point> visitedPoints = new ArrayList<>();

        Queue<Point> queue = new LinkedList<>();

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1}
        };
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                Point tmpPoint = null;
                if (grid[i][j] == 1) {
                    tmpPoint = new Point(i, j);
                    queue.add(tmpPoint);
                    visitedPoints.add(tmpPoint);
                }
                while (!queue.isEmpty()) {
                    tmpPoint = queue.poll();
                    if (visitedPoints.contains(tmpPoint) && queue.isEmpty()) {
                        result++;
                    }
                    visitedPoints.add(tmpPoint);
                    List<Point> allNeighbours = getListOfneighbours(grid, tmpPoint.x, tmpPoint.y, grid.length, grid[0].length);

                    for (Point currNeighbour : allNeighbours) {
                        if (grid[currNeighbour.x][currNeighbour.y] == 1) {
                            if (!visitedPoints.contains(tmpPoint))
                                queue.add(currNeighbour);
                        }
                    }
                }
            }
        }
        System.out.println(result);


    }

    static List<Point> getListOfneighbours(int[][] grid, int tmpX, int tmpY, int M, int N) {
        List<Point> retVal = new ArrayList<>();
        /*
        {1, 1, 0, 0, 0},
        {1, 0, 1, 1, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 1}
        */

        if (tmpX > 0) retVal.add(new Point(tmpX - 1, tmpY));
        if (tmpX < M - 1) retVal.add(new Point(tmpX + 1, tmpY));
        if (tmpY > 0) retVal.add(new Point(tmpX, tmpY - 1));
        if (tmpY < N - 1) retVal.add(new Point(tmpX, tmpY + 1));

        return retVal;


    }
}


