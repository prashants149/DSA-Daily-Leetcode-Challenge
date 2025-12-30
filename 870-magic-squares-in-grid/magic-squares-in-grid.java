class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        if (grid[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = grid[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        int s = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        for (int i = 0; i < 3; i++) {
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != s) return false;
            if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != s) return false;
        }

        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != s) return false;
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != s) return false;

        return true;
    }
}
