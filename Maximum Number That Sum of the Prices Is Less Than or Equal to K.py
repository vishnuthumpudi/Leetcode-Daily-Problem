class Solution:
    def findMaximumNumber(self, k: int, x: int) -> int:
        l, r = 0, 343778878348159
        v = 1 << x - 1
        v1 = 1 << x
        while l <= r:
            m = (l + r) // 2
            tmp = v
            res = 0
            while tmp <= m:
                x, y = divmod(m, 2 * tmp)
                res += x * tmp + max(0, y - tmp + 1)
                tmp *= v1
            if res > k: r = m - 1
            else: l = m + 1
        return r