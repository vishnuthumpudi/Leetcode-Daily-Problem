#pragma clang attribute push (__attribute__((no_sanitize("address","undefined"))), apply_to=function)

const int mod = 1E9 + 7;

int dp[2][3][4], ts;
array<int, 2> t[1024];

ofstream out("user.out");

int main() {
    ios::sync_with_stdio(0), cin.tie(0);
    for (int n; cin >> n; ts++) t[ts] = {n, ts};
    sort(t, t + ts, [](auto& x, auto& y) { return x[0] < y[0]; });
    
    for (int a : {0, 1})
        for (int l : {0, 1, 2})
            dp[0][a][l] = 1;
    
    int ti = 0;
    for (int i = 1, lim = t[ts - 1][0]; i <= lim; i++) {
#pragma unroll
        for (int a : {0, 1}) {
#pragma unroll
            for (int l : {0, 1, 2}) {
                auto& ans = dp[i & 1][a][l];
                ans = dp[~i & 1][a][0];
                ans += dp[~i & 1][a + 1][0];
                ans -= (ans >= mod) * mod;
                ans += dp[~i & 1][a][l + 1];
                ans -= (ans >= mod) * mod;
            }
        }
        while (t[ti][0] == i)
            t[ti++][0] = dp[i & 1][0][0];
    }
    sort(t, t + ts, [](auto& x, auto& y) { return x[1] < y[1]; });
    for (int i = 0; i < ts; i++)
        out << t[i][0] << "\n";
}

#define main main_

class Solution {
public:
    int checkRecord(int n) {
        return 0;
    }
};

#pragma clang attribute pop
