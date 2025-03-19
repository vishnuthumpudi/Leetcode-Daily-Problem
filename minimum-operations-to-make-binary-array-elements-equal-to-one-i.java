class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int i = 0, j = 2, ans = 0;
        
        while (j < n) {
            if (nums[i] == 0) {
                ans++;
                for (int k = i; k < i + 3; k++) {
                    nums[k] = (nums[k] == 0) ? 1 : 0;
                }
            }
            i++;
            j++;
        }
        
        for (int m = 0; m < n; m++) {
            if (nums[m] == 0) {
                return -1;
            }
        }
        
        return ans;
    }
}
