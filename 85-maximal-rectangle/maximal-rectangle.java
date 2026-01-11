class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] stack = new int[n + 1];
        int top = -1;
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? 0 : h[i];
            while (top >= 0 && h[stack[top]] > cur) {
                int height = h[stack[top--]];
                int width = (top < 0) ? i : i - stack[top] - 1;
                max = Math.max(max, height * width);
            }
            stack[++top] = i;
        }
        return max;
    }
}







        
    
