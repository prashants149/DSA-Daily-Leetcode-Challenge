class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> result = new ArrayList<>(n);

        int remain = 0;

        for (int i = 0; i < n; i++) {
            remain = (remain * 2 + nums[i]) % 5;
            result.add(remain == 0);
        }
        return result;
        
    }
}