class Solution:
    def firstPalindrome(self, s: List[str]) -> str:
        n = len(s)
        for i in range(n):
            is_palin = True
            n1 = len(s[i])
            mid = (n1+1)//2
            for j in range(mid):
                is_palin = (is_palin & (s[i][j]==s[i][n1-1-j]))
            if is_palin : 
                return s[i]
        return ""
