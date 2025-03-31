package org.example.leetcode.arrays.matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumberofIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return funcDfs(grid, 0, 0, visited, 0);

    }

    private static int funcDfs(char[][] grid, int i, int j, boolean[][] visited, int count) {
        while (getNextStartOfIsland(grid, i, j, visited) != null) {
            Holder holder = funcDfs(grid, i, j, visited);
            visited = holder.visited;
            i = holder.idxArr[0];
            j = holder.idxArr[1];
            count++;
        }
        return count;
    }

    private static Holder funcDfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] idxArr = getNextStartOfIsland(grid, i, j, visited);
        if (idxArr == null) {
            return new Holder(visited, null);
        }
        visited[idxArr[0]][idxArr[1]] = true;

        int[][] neighbours = getNeighbours(idxArr[0], idxArr[1], grid.length, grid[0].length);

        List<Holder> holders = new ArrayList<>();
        for (int[] neighbour : neighbours) {
            if (neighbour == null || grid[neighbour[0]][neighbour[1]] == '0') {
                continue;
            }
            if (!visited[neighbour[0]][neighbour[1]]) {
                Holder holder = funcDfs(grid, neighbour[0], neighbour[1], visited);
                holders.add(holder);
            }
        }
        return holders.isEmpty() ? new Holder(visited, idxArr) : holders.stream().max(Comparator.comparingInt(a -> a.idxArr[1])).orElse(null);
    }

    private static class Holder {
        boolean[][] visited;
        int[] idxArr;

        public Holder(boolean[][] visited, int[] idxArr) {
            this.visited = visited;
            this.idxArr = idxArr;
        }
    }

    private static int[] getNextStartOfIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (!visited[i][j] && grid[i][j] == '1') {
            return new int[]{i, j};
        }
        for (int l = 0; l < grid.length; l++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (!visited[l][k] && grid[l][k] == '1') {
                    return new int[]{l, k};
                }
            }
        }
        return null;
    }

    private static int[][] getNeighbours(int i, int j, int m, int n) {
        int[][] r = new int[4][2];
        r[0] = i + 1 < m ? new int[]{i + 1, j} : null;
        r[1] = j + 1 < n ? new int[]{i, j + 1} : null;
        r[2] = i - 1 >= 0 ? new int[]{i - 1, j} : null;
        r[3] = j - 1 >= 0 ? new int[]{i, j - 1} : null;
        return r;
    }

}
