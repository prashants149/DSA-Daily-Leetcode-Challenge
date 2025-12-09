class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int maxVal = 200000;
        long[] prefix = new long[maxVal + 1];
        long[] suffix = new long[maxVal + 1];
        long mod = 1_000_000_007L;

        for (int v : nums) {
            suffix[v]++;
        }

        long ans = 0;
        for (int j = 0; j < n; j++) {
            int v = nums[j];
            suffix[v]--;
            int d = v * 2;
            if (d <= maxVal) {
                long left = prefix[d];
                long right = suffix[d];
                ans = (ans + (left * right) % mod) % mod;
            }
            prefix[v]++;
        }

        return (int) ans;
        
    }
}