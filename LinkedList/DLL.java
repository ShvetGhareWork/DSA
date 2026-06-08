package LinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null; // Explicitly initialize
            this.prev = null; // Explicitly initialize
        }
    }

    public void InsertAtFirst(int value) {
        Node newNode = new Node(value);
        
        if (head == null) {
            // List is empty: new node is both head and tail
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void InsertAtLast(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            // List is empty: new node is both head and tail
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void InsertAtIndex(int value, int index){
    Node temp = head;
    for(int i = 1; i < index; i++){
        temp = temp.next;
    }
    
    Node newNode = new Node(value);
    newNode.next = temp.next;
    newNode.prev = temp;
    if(temp.next != null){
        temp.next.prev = newNode;
    }
    temp.next = newNode;
    length++;

}

    public void Display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void DisplayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }
}   