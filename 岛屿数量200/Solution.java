package 岛屿数量200;

/**
 * @author klhu03
 * @since 2024/12/04 17:35
 **/
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vi = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(vi[i][j] || (grid[i][j] == '0')) {
                    continue;
                }
                dfs(grid, i, j, vi);
                res++;
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if(i+1 <=grid.length-1 && grid[i+1][j] == '1' && visited[i+1][j] == false) {
            dfs(grid, i+1, j, visited);
        }
        if(i-1 >= 0 && grid[i-1][j] == '1' && visited[i-1][j] == false) {
            dfs(grid, i-1, j, visited);
        }
        if(j+1 <= grid[0].length-1 && grid[i][j+1] == '1' && visited[i][j+1] == false){
            dfs(grid, i, j+1, visited);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1' && visited[i][j-1] == false) {
            dfs(grid, i, j-1, visited);
        }
    }
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        new Solution().numIslands(grid);
    }
}
