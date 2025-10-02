class Solution {
    
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange){
            ans += 1;
            emptyBottles = emptyBottles - numExchange + 1;
            numExchange++;
        }
        return ans;
    }
}