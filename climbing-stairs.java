class Solution {
    public int climbStairs(int n) {
        int a=2,b=1,temp=0;
        if(n==1)
        {
            return b;
        }
        if(n==2)
        {
            return a;
        }
        for(int i=3;i<=n;i++)
        {
            temp=a+b;
            b=a;
            a=temp;
            if(i==n)
            {
                break;
            }
        }
        return temp;
    }
}