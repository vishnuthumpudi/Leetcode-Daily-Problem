int dp[1001][1001];
class Solution {
public:
    const int mod=1e9+7;
    int freq[26][1000] = {0};

    int f(int i, int j, const vector<string>& words, const string& target) {
        if (j==0) return 1; 
        if (i<0 || i<j) return 0; 
        if (dp[i][j] != -1) return dp[i][j];

        long long cnt = 0;

        cnt+=f(i-1, j, words, target);

        long long fc=freq[target[j-1]-'a'][i-1];
        if (fc > 0) 
            cnt+= f(i-1, j-1, words, target)*fc;

        return dp[i][j]=cnt%mod;
    }

    int numWays(vector<string>& words, const string& target) {
        const int m=target.size(), n=words[0].size();

        memset(freq, 0, sizeof(freq));
        for (int i = 0; i<n; i++) {
            for (const auto& w : words) 
                freq[w[i]-'a'][i]++;
            
        }


        memset(dp, -1, sizeof(dp));

        return f(n, m, words, target);
    }
};


auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
