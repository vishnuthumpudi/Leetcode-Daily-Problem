class Solution {
    int mod = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        long[] cnt = new long[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;

        while (t-- > 0) {
            long[] updated = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    updated[0] = (updated[0] + cnt[i]) % mod;
                    updated[1] = (updated[1] + cnt[i]) % mod;
                } else {
                    updated[i + 1] = (updated[i + 1] + cnt[i]) % mod;
                }
            }
            cnt = updated;
        }

        long ans = 0;
        for (long c : cnt) ans = (ans + c) % mod;
        return (int) ans;
    }
}
