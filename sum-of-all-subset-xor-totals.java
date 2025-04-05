class Solution {
    private void recursion(int[] nums, int res[], int xor, int idx, int n){
        if(idx == n){
            res[0] += xor;
            return;
        }

        recursion(nums, res, xor, idx+1, n);
        xor ^= nums[idx];
        recursion(nums, res, xor, idx+1, n);
        return;
    }
    public int subsetXORSum(int[] nums) {
        int res[] = {0};
        int n = nums.length;
        recursion(nums, res, 0, 0, n);
        return res[0];
    }
}
