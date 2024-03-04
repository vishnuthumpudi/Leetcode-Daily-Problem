class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0,last=tokens.length,ans=0,i=0;
        quicksort(tokens,0,last-1);
        while(i<last && (power >= tokens[i] || score > 0)){
            if(power >= tokens[i]){
                power -= tokens[i];
                score++;
                i++;
            }
            else{
                score--;
                power += tokens[--last];
            }
            ans = Math.max(score,ans);
        }
        return ans;
    }
    private void quicksort(int[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }
    private int partition(int[] arr, int left, int right) 
    {
        int pivotValue = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) 
        {
            if (arr[j] < pivotValue) 
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }   
}
