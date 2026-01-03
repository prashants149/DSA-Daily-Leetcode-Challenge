class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;
        long typeA = 6;
        long typeB = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (typeA * 2 + typeB * 2) % mod;
            long newB = (typeA * 2 + typeB * 3) % mod;
            typeA = newA;
            typeB = newB;
        }

        return (int)((typeA + typeB) % mod);
    }
}
