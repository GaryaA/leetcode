package math;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
//        return Long.valueOf(byPascalTriangle(m, n)).intValue();

        int[][] uniqPaths = new int[m][n];
        Arrays.fill(uniqPaths[0], 1);
        for (int i = 0; i < uniqPaths.length; i++) {
            uniqPaths[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (uniqPaths[i][j] == 1) continue;
                uniqPaths[i][j] = uniqPaths[i - 1][j] + uniqPaths[i][j - 1];
            }
        }
        return uniqPaths[m - 1][n - 1];
    }

    //Комбинаторика, вычисление факториалов
    public static long byPascalTriangle(int m, int n) {
        long k = 1;
        for (int i = 1; i <= Math.min(m - 1, n - 1); i++) {
            k = k * (n + m - 1 - i) / i;
        }
        return k;
    }

}
