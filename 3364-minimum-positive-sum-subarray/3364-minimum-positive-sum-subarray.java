
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++)
            a[i] = nums.get(i - 1) + a[i - 1];

        int min = Integer.MAX_VALUE;

        for (int i = l; i <= n; i++) {
            for (int j = Math.max(0, i - r); j <= i - l; j++) {
                int sum = a[i] - a[j];

                if (sum > 0)
                    min = Math.min(min, sum);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}