class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        table = [0] * k
        table[0] = 1
        s = 0
        count = 0
        for n in nums:
            s += n
            s %= k
            count += table[s]
            table[s] += 1
        return count
