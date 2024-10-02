class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        hash = dict()
        temp = arr.copy()
        temp.sort()
        rank = 1
        for i in temp:
            if i not in hash.keys():
                hash[i] = rank
                rank += 1
        res = []
        for i in arr:
            res.append(hash[i])
        return res
