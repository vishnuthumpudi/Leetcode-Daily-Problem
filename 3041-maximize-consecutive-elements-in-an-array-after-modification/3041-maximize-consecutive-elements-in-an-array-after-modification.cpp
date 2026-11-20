class Solution {
public:
    int maxSelectedElements(vector<int>& nums) {
        int mx = *max_element(nums.begin(),nums.end());
        vector<int> cnt(mx+1,0),dp(mx+5,0);
        for(int i : nums)
        {
            cnt[i]++;
        }
        int ans = 1;
        for(int i = mx;i>=1;i--)
        {
            if(cnt[i]>=1)
            {
                dp[i] = 1 + dp[i+1];
                dp[i+1] = max(dp[i+1],1 + dp[i+2]);
            }
            if(cnt[i]>=2)
            {
                dp[i] = max(dp[i],2 + dp[i+2]);
            }
            ans = max({ans,dp[i],dp[i+1]});
        }
        return ans;
    }
};