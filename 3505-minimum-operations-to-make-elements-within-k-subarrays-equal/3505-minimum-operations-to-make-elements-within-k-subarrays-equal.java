class Solution {

    class Fenwick {
        int n;
        int[] count;
        long[] sum;

        Fenwick(int n) {
            this.n = n;
            count = new int[n + 1];
            sum = new long[n + 1];
        }

        void update(int idx, int c, long s) {
            for (int i = idx; i <= n; i += i & -i) {
                count[i] += c;
                sum[i] += s;
            }
        }

        int queryCount(int idx) {
            int res = 0;
            for (int i = idx; i > 0; i -= i & -i) {
                res += count[i];
            }

            return res;
        }

        long querySum(int idx) {
            long res = 0;
            for (int i = idx; i > 0; i -= i & -i) {
                res += sum[i];
            }

            return res;
        }

        int kth(int k) {
            int idx = 0;

            for (int bit = Integer.highestOneBit(n); bit > 0; bit >>= 1) {
                int next = idx + bit;

                if (next <= n && count[next] < k) {
                    idx = next;
                    k -= count[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int i = 0; i < n; i++) {
            if (m == 0 || sorted[i] != sorted[m - 1]) {
                sorted[m++] = sorted[i];
            }
        }

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
        }

        Fenwick bit = new Fenwick(m);

        int windows = n - x + 1;
        long[] cost = new long[windows];

        for (int i = 0; i < x; i++) {
            bit.update(rank[i], 1, nums[i]);
        }

        for (int i = 0; i < windows; i++) {
            int medianRank = bit.kth((x + 1) / 2);
            long median = sorted[medianRank - 1];

            int leftCount = bit.queryCount(medianRank);
            long leftSum = bit.querySum(medianRank);

            int rightCount = x - leftCount;
            long rightSum = bit.querySum(m) - leftSum;

            cost[i] = median * leftCount - leftSum + rightSum - median * rightCount;

            if (i + 1 < windows) {
                bit.update(rank[i], -1, -((long) nums[i]));
                bit.update(rank[i + x], 1, nums[i + x]);
            }
        }

        long inf = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, inf);

            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != inf) {
                    long candidate = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], candidate);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}