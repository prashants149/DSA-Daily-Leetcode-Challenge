class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 2][n + 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int v = grid[i - 1][j - 1];
                row[i][j] = row[i][j - 1] + v;
                col[i][j] = col[i - 1][j] + v;
                diag1[i][j] = diag1[i - 1][j - 1] + v;
                diag2[i][j] = diag2[i - 1][j + 1] + v;
            }
        }

        int ans = 1;
        for (int k = 2; k <= Math.min(m, n); k++) {
            for (int i = k; i <= m; i++) {
                for (int j = k; j <= n; j++) {
                    int sum = row[i][j] - row[i][j - k];
                    boolean ok = true;
                    for (int r = i - k + 1; r <= i && ok; r++) {
                        if (row[r][j] - row[r][j - k] != sum) ok = false;
                    }
                    for (int c = j - k + 1; c <= j && ok; c++) {
                        if (col[i][c] - col[i - k][c] != sum) ok = false;
                    }
                    if (ok) {
                        int d1 = diag1[i][j] - diag1[i - k][j - k];
                        int d2 = diag2[i][j - k + 1] - diag2[i - k][j + 1];
                        if (d1 == sum && d2 == sum) ans = k;
                    }
                }
            }
        }
        return ans;
    }
}
