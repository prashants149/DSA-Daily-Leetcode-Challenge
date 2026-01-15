import java.util.*;

class Solution {
    static class Event implements Comparable<Event> {
        int y, x1, x2, type;
        Event(int y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
        public int compareTo(Event other) {
            return Integer.compare(this.y, other.y);
        }
    }

    static class Node {
        int count;
        long length;
    }

    private Node[] tree;
    private int[] coords;

    public double separateSquares(int[][] squares) {
        Set<Integer> xCoords = new TreeSet<>();
        List<Event> events = new ArrayList<>();
        for (int[] s : squares) {
            xCoords.add(s[0]);
            xCoords.add(s[0] + s[2]);
            events.add(new Event(s[1], s[0], s[0] + s[2], 1));
            events.add(new Event(s[1] + s[2], s[0], s[0] + s[2], -1));
        }

        Collections.sort(events);
        coords = new int[xCoords.size()];
        int idx = 0;
        for (int x : xCoords) coords[idx++] = x;

        int m = coords.length;
        tree = new Node[4 * m];
        for (int i = 0; i < 4 * m; i++) tree[i] = new Node();

        double totalArea = 0;
        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, m - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            totalArea += (double) tree[1].length * (events.get(i + 1).y - events.get(i).y);
        }

        for (int i = 0; i < 4 * m; i++) tree[i] = new Node();

        double currentArea = 0;
        double target = totalArea / 2.0;

        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, m - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            double areaInStrip = (double) tree[1].length * (events.get(i + 1).y - events.get(i).y);
            if (currentArea + areaInStrip >= target - 1e-9) {
                return events.get(i).y + (target - currentArea) / tree[1].length;
            }
            currentArea += areaInStrip;
        }

        return events.get(events.size() - 1).y;
    }

    private void update(int node, int start, int end, int L, int R, int val) {
        if (coords[end + 1] <= L || coords[start] >= R) return;
        if (coords[start] >= L && coords[end + 1] <= R) {
            tree[node].count += val;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, L, R, val);
            update(node * 2 + 1, mid + 1, end, L, R, val);
        }

        if (tree[node].count > 0) {
            tree[node].length = coords[end + 1] - coords[start];
        } else if (start != end) {
            tree[node].length = tree[node * 2].length + tree[node * 2 + 1].length;
        } else {
            tree[node].length = 0;
        }
    }
}