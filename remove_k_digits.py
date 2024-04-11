class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if k >= len(num):
            return "0"  

        stack = []
        removed = 0
        
        for digit in num:
            while stack and stack[-1] > digit and removed < k:
                stack.pop()
                removed += 1
            
            stack.append(digit)
        
        while removed < k:
            stack.pop()
            removed += 1
        
 
        result = ''.join(stack).lstrip('0')
        return result if result else "0"  
