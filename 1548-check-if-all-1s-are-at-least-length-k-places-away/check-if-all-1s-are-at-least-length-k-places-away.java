class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int lastone = -(k+1);
        for(int i = 0; i<n; i++){
            if(nums[i] == 1){
                if(i - lastone - 1 < k){
                    return false;
                    
                }
                lastone = i;

            }
        }
        return true;
        
    }
}