class Solution {
public:
    
    int helper(vector<int>&nums,int k,int mid)          // mid means target
    {
        int count = 0;
        int j = 0;
        int n = nums.size();

        for(int i=0;i<n;i++)
        {
            while(j<n && (nums[j]-nums[i])<=mid)
            {
                j++;
            }
            
            count += (j-i-1);               // (j-i-1) ae ind. i thi start thati valid pairs che
        }

        return count;
    }

    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(),nums.end());
        
        int n = nums.size();
        int low = 0;
        int high = nums[n-1]-nums[0];
        int ans = -1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            int count = helper(nums,k,mid);

            if(count>=k)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return ans;
        
        /* This gives TLE for large test-cases
        int n = nums.size();
        vector<int>res;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                res.push_back(abs(nums[i]-nums[j]));
            }
        }

        sort(res.begin(),res.end());
				
        return res[k-1];
        */
    }
};
