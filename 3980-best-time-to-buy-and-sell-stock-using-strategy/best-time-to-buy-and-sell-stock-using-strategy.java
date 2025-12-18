class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        int half = k / 2;
        long maxGain = 0;

        long lost = 0;
        long gain = 0;

        for (int i = 0; i < k; i++) {
            lost += (long) strategy[i] * prices[i];
            if (i >= half) gain += prices[i];
        }

        maxGain = Math.max(maxGain, gain - lost);

        for (int i = k; i < n; i++) {
            lost += (long) strategy[i] * prices[i];
            lost -= (long) strategy[i - k] * prices[i - k];

            gain += prices[i];
            gain -= prices[i - half];

            maxGain = Math.max(maxGain, gain - lost);
        }

        return base + maxGain;
    }
}
