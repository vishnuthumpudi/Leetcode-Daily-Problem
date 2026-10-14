class Solution {
    public String maxSumOfSquares(int num, int sum) {
       if(9*num < sum)return "";
       int n = sum/9;
       int rem = sum%9;
       StringBuilder str = new StringBuilder();
       for(int i=1;i<=n;i++)
       {
             str.append('9');
       }
       char ch = (char)(rem+'0');
       if(str.length()<num)
          str.append(ch);

       for(int i=str.length();i<num;i++)
       {
             str.append('0');
       }
       return str.toString();
    }
}