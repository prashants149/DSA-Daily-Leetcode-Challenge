class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int dec = 0;

        for (int i = happiness.length - 1; i >= 0 && k > 0; i--, k--) {
            int value = happiness[i] - dec;
            if (value > 0) {
                sum += value;
            }
            dec++;
            }
            return sum;
                             
        }
}