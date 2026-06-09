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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        if(head == null || head.next == null){
            return head;
        }
        while(currentNode.next != null){
        if(currentNode.val == currentNode.next.val){
            currentNode.next = currentNode.next.next;
        }else{
            currentNode = currentNode.next;
        }
        }
        return head;
    }

    public void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}