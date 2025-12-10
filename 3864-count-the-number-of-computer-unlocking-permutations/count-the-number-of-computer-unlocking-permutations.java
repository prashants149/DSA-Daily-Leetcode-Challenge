class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; ++i) if (complexity[0] >= complexity[i]) return 0;
        long MOD = 1_000_000_007L;
        long ans = 1;
        for (int i = 1; i <= n - 1; ++i) ans = (ans * i) % MOD;
        return (int) ans;

        
    }
}