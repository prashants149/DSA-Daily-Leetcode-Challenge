class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            for (int a = 0; a <= x; a++) {
                if ( (a | (a + 1)) == x ) {
                    res = a;
                    break;
                }
            }
            ans[i] = res;
        }
        return ans;
        
    }
}