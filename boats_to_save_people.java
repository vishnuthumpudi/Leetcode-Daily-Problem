class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // TC : O(nlogn)
        // SC : O(1)
        // int i = 0;
        // int j = people.length - 1;
        // int ans = 0;
        // Arrays.sort(people);
        // while(i<=j){
        //     if(people[i] + people[j] <= limit){
        //         i++;
        //         ans++;
        //     }else if(people[j] <= limit){
        //         ans++;
        //     }
        //     j--;
        // }
        // return ans;


               //optimized
        // TC: O(n)
        // SC: O(n)

        int[] buckets = new int[limit + 1];
        for(int weight : people ){
            buckets[weight]++;
        } 


        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while(start<=end){
            while(start<=end && buckets[start] <= 0 ) start++;
            while(start<=end && buckets[end] <= 0 ) end--;

            if(buckets[start] <=0 && buckets[end] <=0) break;

            boats++;
            if(start + end <= limit){
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }
}
