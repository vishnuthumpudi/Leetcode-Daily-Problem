class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        result = []

        for i in range(len(s) - len(a) + 1):
            if s[i:i+len(a)] == a:
                for j in range(max(0, i - k), min(len(s) - len(b) + 1, i + k + 1)):
                    if s[j:j+len(b)] == b:
                        result.append(i)
                        break

        return result