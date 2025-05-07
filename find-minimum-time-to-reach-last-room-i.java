class Pair {
    int x;
    int y;
    int time;

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;

        int[][] dist = new int[n][m];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int r = top.x;
            int c = top.y;
            int t = top.time;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int nt = 1 + Math.max(t, moveTime[nr][nc]);
                    if (dist[nr][nc] > nt) {
                        dist[nr][nc] = nt;
                        pq.offer(new Pair(nr, nc, nt));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
