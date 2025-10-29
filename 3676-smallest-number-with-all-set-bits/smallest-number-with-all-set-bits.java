class Solution {
    public int smallestNumber(int n) {
        int bits = (int)(Math.log(n) / Math.log(2)) + 1;
        return (1 << bits) - 1;
        
    }
}