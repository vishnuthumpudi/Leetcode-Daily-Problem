class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int distinctCount = 0;
        int arrCount = distinct(nums, 0, n-1);

        for(int i = 0; i <= n-arrCount; i++){
            for(int j = i+arrCount-1; j<n; j++){
                int subCount = distinct(nums, i, j);
                if(arrCount == subCount) distinctCount++;
            }
        }
        return distinctCount;
    }
    public int distinct(int[] nums, int start, int end){
        int[] freq = new int[2001];
        int count = 0;

        for(int i = start; i <= end; i++){
            freq[nums[i]]++;
            if(freq[nums[i]] == 1) count++;
        }

        return count;
    }
}
