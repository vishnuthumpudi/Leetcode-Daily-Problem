class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        def rank(mp, a):
            return mp.get(a, len(mp))
    
        mp = {num: i for i, num in enumerate(arr2)}
        arr1.sort(key=lambda x: (rank(mp, x), x))
        return arr1
