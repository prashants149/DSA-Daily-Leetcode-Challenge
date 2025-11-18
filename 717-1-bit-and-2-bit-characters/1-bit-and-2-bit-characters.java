class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int count1 = 0;

        for (int i = n - 2; i >= 0 && bits[i] == 1; i--) {
            count1++;
        }
        return (count1 % 2 == 0);
        
    }
}