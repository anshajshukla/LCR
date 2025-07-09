/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Normal Approach of hash set and loop
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head!=null){
            if(s.contains(head)) return true;
            s.add(head);
            head=head.next;
        }
        return false;
        
    }
}
