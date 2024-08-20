class Solution:
    def dp(self,i,nums,m,turn,dct):
        if i>=len(nums):
            return 0
        if (i,m,turn) in dct:
            return dct[(i,m,turn)]
        mx=0
        if turn:
            for j in range(1,(2*m)+1):
                x=self.dp(i+j,nums,max(m,j),False,dct)+sum(nums[i:i+j])
                mx=max(mx,x)
            dct[(i,m,turn)]=mx
            return mx
        else:
            mn=float("infinity")
            for j in range(1,(2*m)+1):
                y=self.dp(i+j,nums,max(m,j),True,dct)
                # print(y)
                mn=min(mn,y)
            dct[(i,m,turn)]=mn
            return mn
        

    def stoneGameII(self, piles: List[int]) -> int:
        n=len(piles)
        return self.dp(0,piles,1,True,{})
