/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         // we can keep , the copy of the nodes in after the values , point them and then do random pointer , could also be done with hm.

        // First step e9curr != null
        // create temp copies
        if(head == null) return head;

        Node curr = head;
        while(curr != null){
            Node temp = new Node(curr.val);

            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next; // curr.next.next 

        }

        Node newHead = head.next;

        // we have to deal with random pointerss pointing and be carefull as we do next.next , only make random , when random.next is present . 

        curr = head;

        while(curr != null){
            Node temp = curr.next;
            if(curr.random!=null){
            temp.random = curr.random.next; // we are connecting copies and copies are next to regular random and as we neex to make sure cuu.random is present so if condn
            }
            curr = temp.next;
        }

        // unweave

        curr = head;
        while(curr != null ){
            Node temp = curr.next;
            curr.next = temp.next;
            if(temp.next != null){
            temp.next = temp.next.next;
            }
            curr = curr.next; // original connection done
            
        }

        return newHead ;

    }
}
