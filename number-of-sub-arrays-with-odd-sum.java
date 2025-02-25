class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        int oddCount = 0, evenCount = 1; // Initialize counts for subarrays with odd and even sums
        int totalSum = 0, subArraysWithOddSum = 0; // Initialize the total sum and the result counter

        for (int i = 0; i < n; i++) {
            totalSum += arr[i]; 
            if (totalSum % 2 == 0) {
                evenCount++; 
                // Add the count of subarrays with odd sums ending at previous indices
                subArraysWithOddSum = (subArraysWithOddSum + oddCount) % MOD;
            } else {
                oddCount++;
                // Add the count of subarrays with even sums ending at previous indices
                subArraysWithOddSum = (subArraysWithOddSum + evenCount) % MOD;
            }
        }
        return subArraysWithOddSum;
    }
}
