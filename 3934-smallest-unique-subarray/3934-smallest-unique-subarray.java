class Solution {
    int MOD = 1000000007;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int base = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE) + 1;   
        int l = 1, r = n;
        int ans = n;

        while(l <= r){
            int m = l + (r - l) / 2;

            boolean possible = check(nums, m, base);
            if(possible){
                ans = m;
                r = m - 1;
            }else l = m + 1;
        }

        return ans;

    }

    boolean check(int[] nums, int m, int base){
        int n = nums.length;
        int i = 0, j = 0;
        long hash = 0;
        HashMap<Long, Integer> mp = new HashMap<>();
        long pow = findPowerUsingExpo(base, m - 1);


        while(j < n){
            hash = (hash * base + nums[j]) % MOD;
            if(j - i + 1 < m){
                j++;
            }else {
                
                mp.put(hash, mp.getOrDefault(hash, 0) + 1);
                hash = (hash - (pow * nums[i]) % MOD + MOD) % MOD;
                i++;
                j++;
            }
        }

        for(Map.Entry<Long, Integer> it : mp.entrySet()){
            if(it.getValue() == 1) return true;
        }


        return false;
    }

    long findPowerUsingExpo(long a, long base){
        if(base == 0) return 1;

        long half = findPowerUsingExpo(a, base / 2);
        long res = (half * half) % MOD;

        if(base % 2 == 1) res = (res * a) % MOD;
        return res;

    }

}