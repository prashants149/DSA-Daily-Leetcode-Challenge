class Solution {
    
        void rotate(StringBuilder s, int b) {
            int n = s.length();
            b %= n;
            reverse(s, 0, n - 1);
            reverse(s, 0, b - 1);
            reverse(s, b, n - 1);
        }

        void reverse(StringBuilder s, int l, int r) {
            while (l < r) {
            char temp = s.charAt(l);
            s.setCharAt(l, s.charAt(r));
            s.setCharAt(r, temp);
            l++;
            r--;
        }
        
    }
    void dfs(StringBuilder curr, int a, int b, Set<String> visited, StringBuilder smallest) {
        String str = curr.toString();
        if (visited.contains(str)) return;
        visited.add(str);

        if (str.compareTo(smallest.toString()) < 0)
            smallest.replace(0, smallest.length(), str);
    

    StringBuilder added = new StringBuilder(str);
    for (int i = 1; i < added.length(); i += 2) {
        int newDigit = (added.charAt(i) - '0' + a) % 10;
        added.setCharAt(i, (char) (newDigit + '0'));
    }
    dfs(added, a, b, visited, smallest);

    StringBuilder rotated = new StringBuilder(str);
    rotate(rotated, b);
    dfs(rotated, a, b, visited, smallest);
}
public String findLexSmallestString(String s, int a, int b) {
    Set<String> visited = new HashSet<>();
    StringBuilder smallest = new StringBuilder(s);
    dfs(new StringBuilder(s), a, b, visited, smallest);
    return smallest.toString();
        
    }
}