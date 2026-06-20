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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;
        boolean HasCycle = false;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                HasCycle = true;
                do{
                    slow = slow.next;
                    cycleLength++;
                } while(slow != fast);
                break;
            }
        }

        if(!HasCycle){
            return null;
        }

        ListNode f = head;
        ListNode s = slow;

        while(cycleLength > 0){
            s = s.next;
            cycleLength--;
        }
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
}