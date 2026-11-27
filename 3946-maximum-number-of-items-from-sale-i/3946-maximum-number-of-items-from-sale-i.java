class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[1501];
        int minPrice = Integer.MAX_VALUE;

        // Count factor frequencies and find the cheapest item
        for (int[] item : items) {
            freq[item[0]]++;
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // Precompute how many items have a factor divisible by f
        // Using the harmonic series trick reduces precomputation to O(M log M)
        int[] divisibleCount = new int[1501];
        for (int f = 1; f <= 1500; f++) {
            if (freq[f] > 0) {
                for (int multiple = f; multiple <= 1500; multiple += f) {
                    divisibleCount[f] += freq[multiple];
                }
            }
        }

        // 0/1 Knapsack DP for the first purchase of each item
        int[] dp = new int[budget + 1];
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gainedItems = divisibleCount[factor]; // 1 purchased + (divisibleCount - 1) free

            for (int b = budget; b >= price; b--) {
                int candidate = dp[b - price] + gainedItems;
                if (candidate > dp[b]) {
                    dp[b] = candidate;
                }
            }
        }

        // Spend any remaining budget greedily on the cheapest item
        int maxItems = 0;
        for (int b = 0; b <= budget; b++) {
            int total = dp[b] + (budget - b) / minPrice;
            if (total > maxItems) {
                maxItems = total;
            }
        }

        return maxItems;
    }
}