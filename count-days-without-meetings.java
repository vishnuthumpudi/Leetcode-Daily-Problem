class Solution {
    public int countDays(int days, int[][] meetings) {
        int n=meetings.length;

        if(n==1){
            return days-(meetings[0][1]-meetings[0][0]+1);
        }

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        for(int i=1; i<n; i++){
            // Merge overlapping intervals.
            if(meetings[i-1][1]>=meetings[i][0]){
                meetings[i][0]=meetings[i-1][0];                
                meetings[i][1]=Math.max(meetings[i-1][1], meetings[i][1]);
            }else{
                // Subtract the length of the non-overlapping interval.
                days-=meetings[i-1][1]-meetings[i-1][0]+1;
            }   
        }

        // Account for the last merged interval.        
        days-=meetings[n-1][1]-meetings[n-1][0]+1;

        return days;
    }
}
