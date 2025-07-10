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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> s = new Stack<>();
        while(head!=null) {
            s.add(head);
            head=head.next;
        } // Now head becomes null

        // ListNode newhead = s.pop();
        // while(!s.empty()){
        //     newhead.next = s.pop();
        //     newhead=newhead.next;
        // }
        // newhead.next=null;
        // return newhead;

// In above example i m taking only head in the cosideration without a fact 
// that head should point to the first character only then attach diff node with themselves
        ListNode newhead = s.pop();
        ListNode node = newhead;
        while(!s.empty()){
            node.next = s.pop();
            node=node.next;
        }
        node.next=null;
        
        return newhead;
        
    }
}
