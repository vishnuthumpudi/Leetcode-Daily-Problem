class Solution {
    public int maximumCount(int[] nums) {
        int max_pos = 0;
        int max_neg = 0;

        for(int i : nums){
            if(i < 0){
                max_neg++;
            }

            if(i > 0){
                max_pos++;
            }
        }

        return (int)Math.max(max_pos, max_neg);
    }
}
