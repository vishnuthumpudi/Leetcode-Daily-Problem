class Solution {
    public int minOperations(int[] nums, int k) {
        int res=0;
        // Add all elements to the priority queue
        PriorityQueue<Long> pq=new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++){
            pq.add((long)nums[i]);
        }

        long x,y;
        // Continue combining elements until the smallest element is >= k
        while(pq.peek()<k){
            //System.out.println("    pq="+pq.toString());
            x=pq.poll();
            if(!pq.isEmpty()){                
                y=pq.poll();
                //System.out.println("        x="+x+"; y="+y);
                pq.add((long)x*2+y);
                res++;
            }else{
                break;
            }
            
        }


        return res;
    }
}
