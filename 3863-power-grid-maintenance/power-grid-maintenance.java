class Solution {
    private void bfs(int start, Map<Integer, List<Integer>> adj, int id,
                    int[] nodeId, Map<Integer, TreeSet<Integer>> mp,
                    boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        nodeId[start] = id;

        mp.computeIfAbsent(id, k -> new TreeSet<>()).add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int ngbr : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    nodeId[ngbr] = id;
                    mp.get(id).add(ngbr);
                    q.offer(ngbr);
                }
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[c + 1];
        int[] nodeId = new int[c + 1];
        Map<Integer, TreeSet<Integer>> mp = new HashMap<>();

        for (int node = 1; node <= c; node++) {
            if (!visited[node]) {
                int id = node;
                bfs(node, adj, id, nodeId, mp, visited);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int node = query[1];
            int id = nodeId[node];

            if (type == 1) {
                TreeSet<Integer> set = mp.get(id);
                if (set != null && set.contains(node)) {
                    result.add(node);
                } else if (set != null && !set.isEmpty()) {
                    result.add(set.first());
                } else {
                    result.add(-1);
                }
            }else {
                TreeSet<Integer> set = mp.get(id);
                if (set != null) {
                    set.remove(node);
                }
            }

        }
        return result.stream().mapToInt(i -> i).toArray();    
    }
}