class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        while(low <= high){
            int mid = (low + high)/2;

            if(canship(weights, days, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
    private boolean canship(int [] weights, int days, int capacity){
        int cl = 0;
        int rd = 1;

        for(int w : weights){
            if(cl + w <= capacity){
                cl += w;
            }else{
                rd++;
                cl = w;
            }
        }
        return rd <= days;
    }
}