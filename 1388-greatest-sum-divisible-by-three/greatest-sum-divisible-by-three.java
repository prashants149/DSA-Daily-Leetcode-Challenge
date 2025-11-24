class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n + 1][3];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], Integer.MIN_VALUE);
                                
        }
        t[n][0] = 0;
        t[n][1] = Integer.MIN_VALUE;
        t[n][2] = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int rem = 0; rem < 3; rem++) {

                int newRem = (rem + nums[i]) % 3;

                int pick = (t[i + 1][newRem] == Integer.MIN_VALUE)
                            ? Integer.MIN_VALUE
                            : nums[i] + t[i + 1][newRem];
                int notPick = t[i + 1][rem];
                t[i][rem] = Math.max(pick, notPick);
            }
        }
        return t[0][0];
    }
}
                                                                                                                                                          
                                                                                                                                                                  
         
        
    
