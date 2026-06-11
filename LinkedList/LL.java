package LinkedList;
public class LL {

    private Node head;
    private Node tail;
    private int length;

    public LL() {
        // this.head = null;
        // this.tail = null;
        this.length = 0;
    }


    public void InsertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        length++;
    }

    public void InsertAtLast(int value){
        Node node = new Node(value);
        if(tail == null){
            InsertAtFirst(value);
            return;
        }
        else{
            tail.next = node;
            tail = node;
            length++;
        }
    }

    public void InsertAtIndex(int value, int index){

        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }

        if(index == 0){
            InsertAtFirst(value);
            return;
        }
        if(index == length){
            InsertAtLast(value);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node NewNode = new Node(value, temp.next);
        temp.next = NewNode;
        length++;
    }

    // Insert using recurision
    public void InsertAtIndexWithRecurision(int value, int index){
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        
        if(index == 0){
            InsertAtFirst(value);
            return;
        }
        if(index == length){
            InsertAtLast(value);
            return;
        }
        Node temp = head;
        temp = temp.next;
        InsertAtIndexWithRecurision(value, index - 1);
        Node newNode = new Node(value);
        temp.next = newNode;
        temp = newNode;
    }

    public void Display(){
        // // 1
        // System.out.print(temp.value + " ");
        // Display(value, temp.next);
        // Others way to display the linked list
        // 2
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");

        if(temp == null) {
            return;
        }
    }

    public Node Get(int index){
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void DeleteAtFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
        length--;
    }

    public void DeleteAtLast(){
        if(length <= 1){
            DeleteAtFirst();
            return;
        }

        Node secondLast = Get(length - 2);
        secondLast.next = null;
        tail = secondLast;
        length--;   
    }

    public void DeleteAtIndex(int index){
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        if(index == 0){
            DeleteAtFirst();
            return;
        }
        if(index == length - 1){
            DeleteAtLast();
            return;
        }

        Node prev = Get(index - 1);
        prev.next = prev.next.next;
        length--;
    }

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

    private class Node{
        private int value;
        private Node next;
    

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    }

}