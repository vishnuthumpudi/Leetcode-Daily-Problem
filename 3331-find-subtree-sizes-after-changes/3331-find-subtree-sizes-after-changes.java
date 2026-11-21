class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        int[] prev = new int[n];

        Arrays.fill(last, -1);

        int[] stack = new int[2 * n + 1];
        int top = 0;
        stack[top++] = 1;

        while (top > 0) {
            int event = stack[--top];

            if (event > 0) {
                int u = event - 1;
                int c = s.charAt(u) - 'a';

                prev[u] = last[c];

                if (last[c] != -1) {
                    newParent[u] = last[c];
                }

                last[c] = u;

                stack[top++] = -(u + 1);

                for (int v : adj[u]) {
                    stack[top++] = v + 1;
                }
            } else {
                int u = -event - 1;
                int c = s.charAt(u) - 'a';

                last[c] = prev[u];
            }
        }

        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : tree[u]) {
                stack[top++] = v;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}