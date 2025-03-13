class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] line = new int[n + 1]; // Difference array
        int decrement = 0, k = 0; // Keep track of applied queries

        for (int i = 0; i < n; i++) { // Traverse through nums[]
            while (decrement + line[i] < nums[i]) { // If we need more decrements
                if (k == queries.length) return -1; // No more queries left
                
                int li = queries[k][0], ri = queries[k][1], vali = queries[k][2];
                k++; // Move to the next query

                if (ri < i) continue; // Skip if query does not affect current index
                
                line[Math.max(li, i)] += vali; // Start decrement at li (or current i)
                line[ri + 1] -= vali; // Stop decrement after ri
            }
            decrement += line[i]; // Accumulate applied decrements
        }
        return k;
    }
}
