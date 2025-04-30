class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        res = 0
        for i in nums:
            s = str(i)
            l = len(s)
            if l % 2 == 0:
                res += 1
        return res
