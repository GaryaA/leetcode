package org.example.leetcode.arrays.matrix;

public class MatrixDiagonalSum {

    public static void main(String[] args) {
        int[][] matr = new int[][]{
                {7, 3, 1, 9},
                {3, 4, 6, 9},
                {6, 9, 6, 6},
                {9, 5, 8, 5}
        };

        System.out.println(new MatrixDiagonalSum().diagonalSum(matr));
    }

    public int diagonalSum(int[][] mat) {
        int r = 0;
        for (int i = 0; i < mat.length; i++) {
            r += mat[i][i];
            int j = mat.length - 1 - i;
            if (i == j) {
                continue;
            }
            r += mat[j][i];
        }
        return r;
    }

}
