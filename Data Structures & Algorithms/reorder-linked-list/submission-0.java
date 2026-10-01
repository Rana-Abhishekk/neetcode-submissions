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
    public void reorderList(ListNode head) {
                // we have this question as a combination , where we find the middle , then reverse the second part pointers , then do the reorder.
        ListNode slow = head;
        ListNode fast = head;
        // finding middle 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // we have to reverse the part after the middle , so after the slow node, hence we create a new secondHead node which acts as a refrence to the second list which will be reversed.  and we also detatch from middle as the slow pointer will become last elaement

        ListNode secondHead = slow.next;
        slow.next = null;

        // now we will reverse from the second head by the help of prev, curr and next ponter nodes.
        ListNode prev = null;
        ListNode curr = secondHead;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            // move prev and current .
            prev = curr;
            curr = next;
        }

        // the second head is reversed , and prev is the new head of reversed list 

        // Now the reorder step ...
        ListNode curr1,curr2,next1,next2;
        curr1 = head;
        curr2 = prev; // head of new LL
        while(curr2!=null){
            next1 = curr1.next;
            next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr2 = next2;
            curr1 = next1;
        }
    }
}
