class Solution {
    static class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    static class State {
        int node;
        long dist;
        State(int n, long d) {
            node = n;
            dist = d;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] out = new ArrayList[n];
        List<Edge>[] in = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            out[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]].add(new Edge(e[0], e[2]));
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;

            if (d > dist[u]) continue;

            for (Edge e : out[u]) {
                if (dist[e.to] > d + e.cost) {
                    dist[e.to] = d + e.cost;
                    pq.offer(new State(e.to, dist[e.to]));
                }
            }

            for (Edge e : in[u]) {
                long nd = d + 2L * e.cost;
                if (dist[e.to] > nd) {
                    dist[e.to] = nd;
                    pq.offer(new State(e.to, nd));
                }
            }
        }

        return dist[n - 1] >= INF ? -1 : (int) dist[n - 1];
    }
}
