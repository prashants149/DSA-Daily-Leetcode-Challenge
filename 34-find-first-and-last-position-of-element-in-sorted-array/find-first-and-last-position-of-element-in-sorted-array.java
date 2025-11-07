class Solution {
    public int findFirstPostion(int [] nums, int target){
        int i = 0, r = nums.length-1;
        int result = -1;
        
        while(i <= r){
            int mid = i + (r - i)/2;
            if(nums[mid] == target){
                result = mid;
                r = mid-1;
            }else if(nums[mid] > target){
                r = mid-1;

            }else {
                i = mid+1;
            }
        }
        return result;
    }

    public int findLastPostion(int [] nums, int target){
        int i = 0, r = nums.length-1;
        int result = -1;
        while(i <= r){
            int mid = i + (r-i)/2;
            if(nums[mid] == target){
                result = mid;
                i = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                i = mid+1;
            }
            
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstPostion = findFirstPostion(nums, target);
        int lastPostion = findLastPostion(nums , target);
        return new int[]{firstPostion, lastPostion};
        
    }
}