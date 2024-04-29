class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
       return bitset<20>(accumulate(nums.begin(), nums.end(), k, bit_xor<>())).count();
    }
};
