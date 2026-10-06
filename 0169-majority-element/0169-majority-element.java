class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int element = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(count == 0) {
                element = nums[i];
                count = 1;
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        int elementFrequency = 0;

        for(int num : nums) {
            if(num == element) {
                elementFrequency++;
            }
        }

        return elementFrequency > (n / 2) ? element : -1;
    }
}