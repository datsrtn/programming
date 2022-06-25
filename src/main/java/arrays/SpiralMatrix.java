package arrays;


// Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

public class SpiralMatrix {
    public static void main(String[] args) {
        int A = 5;
        int maxVal = A * A;
        int[][] retVal = new int[A][A];
        int currVal = 1;
        int currRow = 0;
        int currCol = 0;
        int currDirection = 0; // 0-> R         // 1-> L         // 2 ->D         // 3-> U
        int minRow = 0, minCol = 0, maxCol = A, maxRow = A;
        while (currVal <= maxVal) {
            retVal[currRow][currCol] = currVal++;

            if (currDirection == 0) {
                if ((currCol + 1) == maxCol) { // moving right
                    currDirection = 2;
                    minRow++;
                } else {
                    currCol++;
                }
            }
            if (currDirection == 2) {
                if ((currRow + 1) == maxRow) { // moving down
                    currDirection = 1;
                    maxCol--;
                } else {
                    currRow++;
                }
            }
            if (currDirection == 1) {
                if (currCol == minCol) { // moving left
                    currDirection = 3;
                    maxRow--;

                } else {
                    currCol--;
                }
            }
            if (currDirection == 3) {
                if (currRow == minRow) { // moving up
                    currDirection = 0;
                    minCol++;
                    currCol++;
                } else {
                    currRow--;
                }
            }
        }
        for (int i = 0; i < retVal.length; i++) {
            System.out.println();
            for (int j = 0; j < retVal.length; j++) {
                System.out.print(retVal[i][j] + "   ");
            }
        }
    }
}