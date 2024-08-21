class Solution:
    def strangePrinter(self, s: str) -> int:
        new = [c for i, c in enumerate(s) if i == len(s) - 1 or c != s[i + 1]]
        n = len(new)

        @functools.cache
        def f(i, j):
            ans = 0 if i == j else 1 + f(i + 1, j)
            for k in range(i + 2, j):
                if new[k] == new[i]:
                    ans = min(ans, f(i + 1, k) + f(k, j))

            return ans

        return f(0, n)
