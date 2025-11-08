class Solution {
    public int getNumofBouquets(int [] bloomDay, int mid, int k){
        int numofBouquets = 0;
        int consecutiveCount = 0;

        for(int i =0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            } if(consecutiveCount == k){
                numofBouquets++;
                consecutiveCount = 0;

            }
        }
        return numofBouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){
            return -1;
        }
        int startday = 1;
        int endday = Arrays.stream(bloomDay).max().getAsInt();
        int mindays = -1;
        while(startday <= endday){
            int mid = startday + (endday - startday)/2;

            if(getNumofBouquets(bloomDay, mid, k) >= m){
                mindays = mid;
                endday = mid -1;
            }else {
                startday = mid+1;
            }
        }
        return mindays;
        
    }
}