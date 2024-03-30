int cnt[20001];


class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        return subcount(nums, k) - subcount(nums, k-1);
    }

    int subcount(vector<int>& nums, int k) {
        memset(cnt, 0, 20001 * sizeof(int));
        int c=1, res=0;
        cnt[nums[0]] = 1;
        auto head = nums.begin(), tail = nums.begin();
        while (head < nums.end()) {
            if (c <= k && tail < nums.end()) {
                tail++;
                if (tail < nums.end()) {
                    cnt[*tail]++;
                    if (cnt[*tail] == 1) c++;
                }
            } else {
                res += (int)(tail - head - 1);
                cnt[*head]--;
                if (cnt[*head] == 0) c--;
                head++;
            } 
        }
        return res;
    }
};
