class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[start] > k) {
                count++;
                start = i;
            }
        }
        count++;

        return count;
    }
}
