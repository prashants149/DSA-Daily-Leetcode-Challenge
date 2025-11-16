class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivotIndex = findPivot(nums, n);
        int idx = binarySearch(nums, 0, pivotIndex-1, target);
        if(idx != -1){
            return idx;
        
        }
        return binarySearch(nums, pivotIndex, n-1, target);
        
    }

    private int findPivot(int[] nums, int n){
        int l =0;
        int r =n-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid +1;
            }else{
                r = mid;
            }

        }
        return r;
    }
    private int binarySearch(int[] nums, int l, int r, int target){
        int result = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                result = mid;
                break;
            }else if(nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return result;
    }
}