class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) totalApples += a;

        int[] freq = new int[51];
        for (int c : capacity) freq[c]++;

        int boxes = 0;

        for (int cap = 50; cap >= 1 && totalApples > 0; cap--) {
            while (freq[cap] > 0 && totalApples > 0) {
                totalApples -= cap;
                freq[cap]--;
                boxes++;
            }
        }
        return boxes;
    }
}
