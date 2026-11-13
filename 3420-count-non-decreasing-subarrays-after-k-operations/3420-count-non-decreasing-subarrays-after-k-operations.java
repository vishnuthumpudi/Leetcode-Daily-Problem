
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        // {prefix maximum, frequency}
        Deque<int[]> dq = new ArrayDeque<>();
        long smreq = 0;
        long ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            int x = nums[l];
            int freq = 1;
            // Merge smaller groups from the back
            while (!dq.isEmpty() && dq.peekLast()[0] < x) {
                int[] last = dq.pollLast();
                smreq += (long) (x - last[0]) * last[1];
                freq += last[1];
            }
            dq.offerLast(new int[]{x, freq});

            // Shrink window from the right
            while (smreq > k) {
                int[] first = dq.pollFirst();
                int value = first[0];
                int count = first[1];
                smreq -= value - nums[r];
                r--;
                if (count > 1) {
                    dq.offerFirst(new int[]{value, count - 1});
                }
            }
            // Count valid subarrays starting at l
            ans += (r - l + 1);
        }
        return ans;
    }
}