class Solution {
    int findPivot(int[] nums, int n){
        int l =0;
        int r =n-1;
        while(l < r){
            while(l < r && nums[l] == nums[l+1]){
                l++;
            }while(l < r && nums[r] == nums[r-1]){
                r--;
            }
            
            int mid = l+(r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;

            }else{
                r = mid;
            }

        }
        return l;
    }

    boolean binarySearch(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
            
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivotIndex = findPivot(nums, n);
        if(binarySearch(nums, 0, pivotIndex - 1, target)){
            return true;
        }

        

        return binarySearch(nums, pivotIndex, n-1, target);
        
    }
}