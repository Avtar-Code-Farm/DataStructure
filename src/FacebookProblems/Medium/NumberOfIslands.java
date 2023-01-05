package FacebookProblems.Medium;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] matrix =  {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int result = numIslands(matrix);


    }

   static int[] pos = {-1, 0 , 1};

    public static int numIslands(char[][] grid) {
        if(grid == null || (grid.length == 0 && grid[0].length == 0)) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0 ; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    do_dfs(grid, visited, i , j);
                    count++;
                }
            }
        }

        return count;

    }

    static boolean  isNbrValid(char[][] grid, int i , int j) {
        if(i >= 0 && j >=0 && i < grid.length && j < grid[0].length) {
            return grid[i][j] == '1';
        }
        else return false;
    }

    static void do_dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;

        int x, y;
        for(int m = 0; m < pos.length; m++) {
            x = pos[m];
            for(int n = 0; n < pos.length; n++) {
                y = pos[n];
                if(x == 0 && y == 0) continue;
                int nbr_i = i + x;
                int nbr_j = j + y;
                if(isNbrValid(grid, nbr_i, nbr_j)) {
                    do_dfs(grid,visited, nbr_i, nbr_j);
                }
            }
        }

    }

}
