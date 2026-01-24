class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> Set = new HashSet<>();
        for(int right = 0; right<s.length(); right++){
            while(Set.contains(s.charAt(right))){
                Set.remove(s.charAt(left));
                left++;
            }
            Set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
        

    }
}