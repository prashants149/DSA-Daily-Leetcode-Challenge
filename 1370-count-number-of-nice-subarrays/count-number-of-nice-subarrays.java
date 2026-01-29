class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private int atMost(int [] nums, int k){
        if(k<0)return 0;
        int left = 0, sum = 0, count = 0;
        for(int right = 0; right<nums.length; right++){
            sum += (nums[right]%2);
            while(sum > k){
                sum -= (nums[left]%2);
                left++;
            }
            count += (right- left +1);
        }
        return count;
    }
}

        
    
