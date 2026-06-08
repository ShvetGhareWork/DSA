package LinkedList;

import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {
        
        LL ll = new LL();
        ll.InsertAtFirst(3);
        ll.InsertAtFirst(2);    
        ll.InsertAtFirst(1);
        ll.InsertAtLast(4);
        ll.InsertAtLast(5);
        ll.InsertAtIndex(6, 5);
        ll.Display();
        ll.DeleteAtFirst();
        ll.Display();
        ll.DeleteAtLast();
        ll.Display();
        ll.DeleteAtIndex(2);
        ll.Display();
        // System.out.println(ll.Get(2).value);
        
    }
}