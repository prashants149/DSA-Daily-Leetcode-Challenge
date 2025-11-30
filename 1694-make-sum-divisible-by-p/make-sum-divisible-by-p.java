class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
            int sum = 0;

            for (int num : nums) {
                sum = (sum + num) % p;
            }

            int target = sum % p;
            if (target == 0) {
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int curr = 0;
            int result = n;

            for (int j = 0; j < n; j++) {
                curr = (curr + nums[j]) % p;
                int remain = (curr - target + p) % p;

                if (map.containsKey(remain)) {
                    result = Math.min(result, j - map.get(remain));
                }
                map.put(curr, j);
                 
            }
            return result == n ? -1 : result;       
        
    }
}