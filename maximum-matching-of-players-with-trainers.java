class Solution {
    public int matchPlayersAndTrainers(int[] player, int[] trainer) {
        int i=0;
        Arrays.sort(player);
        Arrays.sort(trainer);
        int count =0;
        int j=0;
        while(i<player.length && j<trainer.length){
            if(player[i]<=trainer[j]){
                i++;  j++; count++; 
            }
            else{
                j++;
            }
        }
        return count;
        
    }
}
