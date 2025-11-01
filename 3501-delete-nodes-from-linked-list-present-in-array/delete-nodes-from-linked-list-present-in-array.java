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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        while (head != null && st.contains(head.val)) {
            head = head.next;
        }

        ListNode prev = null;
        ListNode curr = head;


        while (curr != null) {
            if (!st.contains(curr.val)) {

                prev = curr;
                curr = curr.next;
            }else{
             if (prev != null) {
                prev.next = curr.next;
             }
             curr = curr.next;
             
        }
    }

    return head;


    }
}