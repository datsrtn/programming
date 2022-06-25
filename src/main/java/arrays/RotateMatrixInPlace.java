package arrays;

public class RotateMatrixInPlace {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // Transpose the matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        // Swap the columns
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A.length - j - 1];
                A[i][A.length - j - 1] = temp;
            }
        }
        for (int[] ints : A) {
            System.out.println();
            for (int j = 0; j < A.length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }
}
