class Solution {
    private void dfs(int[][] grid, int row, int col, int rows, int cols, int direction) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 1 || grid[row][col] == 2) {
            return;
        }
        grid[row][col] = 3;

        if (direction == 1) { // UP
            dfs(grid, row - 1, col, rows, cols, direction);
        } else if (direction == 2) { // DOWN
            dfs(grid, row + 1, col, rows, cols, direction);
        } else if (direction == 3) { // LEFT
            dfs(grid, row, col - 1, rows, cols, direction);
        } else { // RIGHT
            dfs(grid, row, col + 1, rows, cols, direction);
        }
    }
    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        int[][] grid = new int[rows][cols];
        
        

        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 1; 
        
        }
        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 2;
        }
        for (int[] guard : guards) {
            int guardRow = guard[0];
            int guardCol = guard[1];

            


            dfs(grid, guardRow - 1, guardCol, rows, cols, 1); 
            dfs(grid, guardRow + 1, guardCol, rows, cols, 2); 
            dfs(grid, guardRow, guardCol - 1, rows, cols, 3); 
            dfs(grid, guardRow, guardCol + 1, rows, cols, 4);
        }

        int unguardedCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
        
    }
}