class Solution {
    static final int MOD = 1_000_000_007;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length, MAXP = n + 31, maxCarry = m;
        long[] fact = new long[m + 1], invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = modInv(fact[m]);
        for (int i = m - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        long[][] pow = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            pow[i][0] = 1;
            long base = nums[i] % MOD;
            for (int c = 1; c <= m; c++) pow[i][c] = pow[i][c - 1] * base % MOD;
    }
    int C = maxCarry + 1;
    long[][][] curr = new long[C][k + 1][m + 1], next = new long[C][k + 1][m + 1];
    curr[0][0][0] = 1;
    for (int pos = 0; pos < MAXP; pos++) {
        for (int ca = 0; ca <= maxCarry; ca++)
            for (int on = 0; on <= k; on++)
                Arrays.fill(next[ca][on], 0L);
                for (int carry = 0; carry <= maxCarry; carry++)
                    for (int ones = 0; ones <= k; ones++)
                        for (int used = 0; used <= m; used++) {
                        long val = curr[carry][ones][used];
                        if (val == 0) continue;
                        if (pos < n) {
                            int maxC = m - used;
                            for (int c = 0; c <= maxC; c++) {
                                int t = c + carry, bit = t & 1, nc = t >> 1;
                                int nones = ones + bit, nused = used + c;
                                if (nones > k) break;
                                long add = val * pow[pos][c] % MOD * invFact[c] % MOD;
                                next[nc][nones][nused] = (next[nc][nones][nused] + add) % MOD;
                            }
                        } else {
                                int t = carry, bit = t & 1, nc = t >> 1, nones = ones + bit;
                                if (nones <= k)
                                    next[nc][nones][used] = (next[nc][nones][used] + val) % MOD;
                                }
                        }
                        long[][][] tmp = curr; curr = next; next = tmp;
    
    }
    long ans = curr[0][k][m] * fact[m] % MOD;
    return (int) ans;
    }
    private static long modInv(long x) { return modPow(x, MOD - 2); }
        private static long modPow(long a, long e) {
            long r = 1; a %= MOD;
            while (e > 0) {
                if ((e & 1) == 1) r = r * a % MOD;
                a = a * a % MOD; e >>= 1;
            }
            return r;
        }
    }
        
    
