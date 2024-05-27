class Solution {
    public int specialArray(int[] nums) {
        int[] numCounts = new int[nums.length+1];
        for(int num: nums)
            if(num>nums.length)
                numCounts[nums.length]++;
            else
                numCounts[num]++;
        int bigNumsCount = 0;
        for(int specialGuess = nums.length; specialGuess>0; specialGuess--){
            bigNumsCount += numCounts[specialGuess];
            if(bigNumsCount > specialGuess)
                return -1;
            if(bigNumsCount == specialGuess)
                return specialGuess;
        }
        return -1;
    }
}
