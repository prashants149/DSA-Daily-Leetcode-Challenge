class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int n = s.length();
        int result = 0;
        int i = 0;

        while(i<n){
            if(s.charAt(i) == '0'){
                result += count;
                while(i<n  && s.charAt(i)== '0')
                    i++;
            
        }else{
            count++;
            i++;
        }

    }
    return result;
    }
}
