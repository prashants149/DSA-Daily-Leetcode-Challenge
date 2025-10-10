class Solution {
    private int n;
    private int k;
    private int Solve(int i, int[]energy, int[]t){
        if(i>= n) return 0;
        if(k == 0) return energy[i];
        

        if(t[i] != Integer.MIN_VALUE) return t[i];

        t[i] = energy[i] + Solve(i + k, energy, t);

        return t[i];
    }
    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        this.k = k;
        int[]t = new int[n];
        Arrays.fill(t, Integer.MIN_VALUE);
        int maxEnergy = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            maxEnergy = Math.max(maxEnergy, Solve(i, energy, t));
        }
        return maxEnergy;
        
    }
}