class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 1e10;
        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2;
            double below = 0, above = 0;
            for (int[] s : squares) {
                double y = s[1], l = s[2];
                double top = y + l;
                if (mid <= y) {
                    above += l * l;
                } else if (mid >= top) {
                    below += l * l;
                } else {
                    double b = mid - y;
                    double a = top - mid;
                    below += b * l;
                    above += a * l;
                }
            }
            if (below < above) low = mid;
            else high = mid;
        }
        return low;
        
    }
}