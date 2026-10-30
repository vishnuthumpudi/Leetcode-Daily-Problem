class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        int[][] dist = new int[n][k + 1];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[0][1] = 0;
        q.add(new int[] { 0, 0, 1 });
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int distance = current[1];
            int count = current[2];
            if (node == n - 1)
                return distance;
            for (int[] e : adj.get(node)) {
                int neighbour = e[0];
                int weight = e[1];
                int nextCount = (labels.charAt(node) == (labels.charAt(neighbour)) ? count + 1 : 1);
                if (nextCount <= k) {
                    if (weight + distance < dist[neighbour][nextCount]) {
                        dist[neighbour][nextCount] = weight + distance;
                        q.offer(new int[] { neighbour, weight + distance, nextCount });
                    }
                }
            }
        }
        return -1;
    }
}