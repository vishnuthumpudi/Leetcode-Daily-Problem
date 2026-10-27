class Solution {
    public String[] createGrid(int m, int n) {
        String[]ans=new String[m];
        StringBuilder cur=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    cur.append(".");
                }else if(j==n-1){
                    cur.append(".");
                }else{
                    cur.append("#");
                }
            }
            ans[i]=cur.toString();
            cur.setLength(0);
        }
        return ans;
    }
}