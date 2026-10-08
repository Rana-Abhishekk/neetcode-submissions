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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val , b.val));
        // put the first node of every element int he heap 
        for(ListNode head : lists){
            if(head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // now we will pick elements form the heap one by one add them in front of a dummy , after adding we will pull the next element of the node and add that in the heap and keep at it unless heap if empty
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            if(node.next != null) pq.offer(node.next);
            tail = tail.next;
        }
        return dummy.next;
    }
}
