package FacebookProblems.Medium;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathMatrix {
    final static int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}};
        int shortestDistance = getShortestDistance(grid);
    }

    private static int getShortestDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

      //  grid[0][0] = 1; // updated it to 1 since we visited it and cost to visit this cell is 1
        Integer[][] visited = new Integer[m][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = 1; // set the distance of the 0,0 as 1 and then will add it to nbr distance

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curr_distance = visited[curRow][curCol];

            List<int[]> nbrList = getValidNbr(grid, curRow, curCol);
            for(int[] nbr: nbrList ) {
                int nbrRow = nbr[0];
                int nbrCol = nbr[1];

                // find nbr visited state
                Integer nbr_distance = visited[nbrRow][nbrCol];
                if(nbr_distance == null || nbr_distance > curr_distance + 1) {
                    visited[nbrRow][nbrCol] = curr_distance + 1;
                    queue.add(nbr);
                }
            }
        }
        Integer res = visited[m-1][n-1];
        return res == null ? - 1 : res;
    }

    private static List<int[]> getValidNbr(int[][] grid, int row, int col) {
        List<int[]> nbr = new ArrayList<>();
        for(int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow < 0 || newCol < 0 ) continue;
            if(newRow >= grid.length || newCol >= grid[0].length) continue;
            if(grid[newRow][newCol] == 1) continue;

            nbr.add(new int[]{newRow, newCol});
        }
        return nbr;
    }
}
