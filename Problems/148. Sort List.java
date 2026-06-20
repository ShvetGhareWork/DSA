class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: 0 or 1 node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Find the middle using Fast & Slow pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To split the list

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list into two halves
        prev.next = null;

        // 2. Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 3. Merge the sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}   