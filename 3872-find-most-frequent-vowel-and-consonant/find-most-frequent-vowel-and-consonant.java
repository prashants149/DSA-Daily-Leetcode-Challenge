class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        HashMap<Character, Integer> consonant = new HashMap<>();

        int maxV = 0, maxC = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel.put(c, vowel.getOrDefault(c,0)+1);
                maxV = Math.max(maxV, vowel.get(c));
                
            } else{
                consonant.put(c, consonant.getOrDefault(c,0)+1);
                maxC = Math.max(maxC, consonant.get(c));
            }   
        }
        return maxV + maxC;
        
    }
}