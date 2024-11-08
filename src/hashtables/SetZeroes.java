package hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SetZeroes {

    public static void main(String[] args) {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        Arrays.asList(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println();
        setZeroes(matrix);
    }

    static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(fr) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if(fc) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        Arrays.asList(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }


}
