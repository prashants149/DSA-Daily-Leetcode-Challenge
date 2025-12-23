class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int[] maxSuffix = new int[n + 1];
        maxSuffix[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            int nextIndex = binarySearch(events, events[i][1] + 1);
            ans = Math.max(ans, value + maxSuffix[nextIndex]);
        }

        return ans;
    }

    private int binarySearch(int[][] events, int target) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
