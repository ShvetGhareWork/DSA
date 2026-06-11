  public class Sol {
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        Node temp = head;
        int cycleLength = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                do{
                    temp = temp.next;
                    cycleLength++;
                }while(temp != fast);
                System.out.println("Cycle Length: " + cycleLength);
                return true; 
            }

        }

        return false;
    }
}  