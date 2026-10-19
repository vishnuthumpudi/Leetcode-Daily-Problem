class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);

        for(int num : nums) {
            if(target == num) {
                result.add(index);
            }
            index++;
        }

        return result;
    }
}