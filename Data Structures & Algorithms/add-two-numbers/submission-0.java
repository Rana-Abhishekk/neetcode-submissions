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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        //as we don't need heads of l1 and l2 , we cna use them as pointers

        while(l1 != null || l2 != null || carry != 0){
            // we are using or conditioin as enven if one of htem is non null addition should be htere
            // we cid l1 or l2 is null , we cna usse value as 0

            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1+v2 +carry;
            carry = val / 10;
            val = val % 10;

            temp.next = new ListNode(val);
            temp = temp.next;

            // moving pinters but with codn.l1  = l1.next...
            l1 =  (l1 != null) ? l1.next : null;
            l2 =  (l2 != null) ? l2.next : null;

        }
        return dummy.next;
    }
}
