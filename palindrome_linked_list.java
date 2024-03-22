class Solution {
    private static final int[] array = new int[100_000];
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
       ListNode h= head;
       final int[] array1 = array;
       int size =0;

       while(h!=null){
           array1[size++] = h.val;
           h=h.next;
       }

       int m = size/2;
       for(int i=0;i<m;i++){
           if(array[i] != array1[--size]){
               return false;
           }
       }
       return true;
    }
}
