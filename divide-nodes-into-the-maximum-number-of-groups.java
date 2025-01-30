import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Step 1: Build adjacency list representation of the graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 2: Initialize variables
        int[] color = new int[n + 1];  // 0: unvisited, 1: color1, -1: color2
        Arrays.fill(color, 0);
        int maxGroups = 0;

        // Step 3: Process each connected component
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {  // Unvisited node, start BFS
                List<Integer> component = new ArrayList<>();
                if (!isBipartiteBFS(graph, i, color, component)) {
                    return -1;  // If the graph is not bipartite, return -1
                }

                // Step 4: Find the maximum depth (longest shortest path) in the component
                int maxDepth = 0;
                for (int node : component) {
                    maxDepth = Math.max(maxDepth, bfsDepth(graph, node));
                }
                maxGroups += maxDepth;
            }
        }
        return maxGroups;
    }

    // BFS to check if the component is bipartite and collect component nodes
    private boolean isBipartiteBFS(List<Integer>[] graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;  // Start coloring with 1
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {  // If not visited
                    color[neighbor] = -color[node]; // Assign opposite color
                    queue.add(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;  // Graph is not bipartite
                }
            }
        }
        return true;
    }

    // BFS to find the longest shortest path (max depth) in a component
    private int bfsDepth(List<Integer>[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
