class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += (nums[j] % 2 == 0) ? b : -a;
                if (sum <= 0) {
                    count++;
                }
            }
        }

        return count;
    }
}