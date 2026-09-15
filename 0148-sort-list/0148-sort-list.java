/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        List<Integer> temp_list = new ArrayList<>();

        ListNode temp = head;

        while(temp != null) {
            temp_list.add(temp.val);
            temp = temp.next;
        }

        temp = head;

        sort(temp_list, 0, temp_list.size() - 1);

        for(int i = 0; i < temp_list.size(); i++) {
            temp.val = temp_list.get(i);
            temp = temp.next;
        }

        return head;
    }

    private void sort(List<Integer> list, int low, int high) {
        if(low >=  high) return;

        int mid = low + (high - low) / 2;
        sort(list, low, mid);
        sort(list, mid + 1, high);
        merge(list, low, mid, high);
    }

    private void merge(List<Integer> list, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high) {
            if(list.get(left) <= list.get(right)) {
                temp.add(list.get(left));
                left++;
            } else {
                temp.add(list.get(right));
                right++;
            }
        }

        while(left <= mid) {
            temp.add(list.get(left));
            left++;
        }

        while(right <= high) {
            temp.add(list.get(right));
            right++;
        }

        for(int i = low; i <= high; i++) {
            list.set(i, temp.get(i - low));
        }
    }
}