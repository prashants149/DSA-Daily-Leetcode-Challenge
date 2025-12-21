class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deletion = 0;
        boolean[] alreadysorted = new boolean[rows - 1];

        

        for(int col=0; col < cols; col++){

            boolean deleted = false;

            for(int row=0; row < rows -1; row++){
                if(!alreadysorted[row]  && 
                strs[row].charAt(col) > strs[row+1].charAt(col)){
                    deletion++;
                    deleted = true;
                    break;
                }

            }
            if(deleted) continue;

            for(int row=0; row < rows -1; row++){
                if(strs[row].charAt(col) < strs[row +1].charAt(col)){
                   alreadysorted[row] = true; 
                }
            }
        }
        return deletion;

        
    }
}