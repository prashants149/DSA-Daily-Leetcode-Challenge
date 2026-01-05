class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int countneg = 0;
        int smallestabsolutevalue = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    countneg++;
                }
                smallestabsolutevalue = Math.min(smallestabsolutevalue, Math.abs(matrix[i][j]));
            }
        }
        if(countneg % 2 == 0){
            return sum;
        }
        return sum - 2*smallestabsolutevalue;
        
    }
}