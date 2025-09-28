class Solution {
    public String largestOddNumber(String num) {
        for(int len = num.length()-1; len>=0; len--){
            int d=num.charAt(len) - '0';
            if(d % 2 !=0)
            return num.substring(0, len+1);
        }
        return "";
        
    }
}