class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        while (!isSorted(nums)) {
            int n = nums.length;
            int idx = 0;
            int minSum = nums[0] + nums[1];
            for (int i = 1; i < n - 1; i++) {
                int s = nums[i] + nums[i + 1];
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }
            int[] next = new int[n - 1];
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (i == idx) {
                    next[k++] = nums[i] + nums[i + 1];
                    i++;
                } else {
                    next[k++] = nums[i];
                }
            }
            nums = next;
            ops++;
        }
        return ops;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
        
    }
}