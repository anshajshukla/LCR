// Where is the cycle
// ''''
//  Mathematical Proof
// t = L + x → total steps slow took to reach meeting point
// fast = 2t → fast took double steps
// So:
//     2t - t = t = kC
//     ⇒ L + x = kC
//     ⇒ L = kC - x
// When we reset one pointer to head and move both 1 step at a time:
// One covers L steps
// One covers C−x then wraps around

// They meet at cycle start in L steps.
// '''
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                fast = head;
                int count=-1;
                while(slow!=fast){
                    fast = fast.next;
                    slow= slow.next;
                }
                return slow;
                
            }
        }
        return null;
        
    }
}