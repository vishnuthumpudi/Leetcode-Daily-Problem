class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(int box : initialBoxes) {
            q.add(new Pair(box, status[box]));
        }

        int count = 0;
        boolean[] visited = new boolean[status.length];
        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int current = p.getKey();
            if(visited[current]) {
                continue;
            }

            if(status[current] == 1) {
                count += candies[current];
                visited[current] = true;

                int[] key = keys[current];
                for(int i : key) {
                    status[i] = 1;
                }

                int[] otherBoxes = containedBoxes[current];
                for(int i : otherBoxes) {
                    q.add(new Pair(i, status[i]));
                }
            }
        }
        return count;
    }
}
