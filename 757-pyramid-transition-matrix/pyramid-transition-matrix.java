class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        
        return dfs(bottom, map);
    }
    
    private boolean dfs(String curr, Map<String, List<Character>> map) {
        if (curr.length() == 1) return true;
        
        List<String> nextLevels = new ArrayList<>();
        build(curr, 0, new StringBuilder(), map, nextLevels);
        
        for (String next : nextLevels) {
            if (dfs(next, map)) return true;
        }
        return false;
    }
    
    private void build(String curr, int idx, StringBuilder sb,
                       Map<String, List<Character>> map,
                       List<String> res) {
        if (idx == curr.length() - 1) {
            res.add(sb.toString());
            return;
        }
        
        String key = curr.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;
        
        for (char c : map.get(key)) {
            sb.append(c);
            build(curr, idx + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
