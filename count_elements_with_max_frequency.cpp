class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> freq(100 ,0);
        for(int i=0; i<n; i++){
            freq[nums[i]-1]++;
        }
        int maxf = INT_MIN;
        for(int i=0; i<100; i++){
            maxf = max(maxf , freq[i]);
        }
        vector<int> maxfreq;
        for(int i=0; i<100; i++){
            if(freq[i] == maxf) maxfreq.push_back(i+1);
        }
        return ((maxfreq.size())*(maxf));
    }
};
