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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // keep fixed gap of n+1 and then remove whats needed . when the fast will be at null
        // 0->0->0->0->0 when fat pointer is at null, slow should be at n+1 behing
            ListNode dummy = new ListNode(0, head);

        ListNode slow =dummy; ListNode fast = dummy;

        // move fast ppointer ahead
        for(int i=0;i<=n;i++){ // be n+1 behind
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
