package assi2;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void show() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //-----Inserting a Node at Any Given Position in a Singly Linked List-----
    public void insertAtPos(int position, int value) {
        ListNode node = new ListNode(value);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    //-----Deleting a Node at Any Given Position in a Singly Linked List-----
    public void deleteAtPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    //-----Deleting a Node After a Given Node in a Singly Linked List-----
    public void deleteAfterNode(ListNode prevListNode) {
        if (prevListNode == null || prevListNode.next == null) {
            System.out.println("Previous node is null.");
            return;
        } else {
            ListNode toDelete = prevListNode.next;
            if(toDelete.next!=null){ // Check if there is a next node
                prevListNode.next = toDelete.next;
                toDelete.next = null;
            } else {
                prevListNode.next = null; // If there is no next node, set the previous node's next to null
            }
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // -------Searching a Node in a Singly Linked List------
    public void searchNode(int value) {
        ListNode current = head;
        boolean found = false;
        while (current != null) {
            //System.out.println(current.data + " ");
            if (current.data == value) {
                found = true;
                break;
            }
            current = current.next;
        }
        System.out.println();
        if (found) {
            System.out.println("NODE FOUND!");
        } else {
            System.out.println("NODE NOT FOUND!");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(14);
        ListNode second = new ListNode(45);
        ListNode third = new ListNode(52);
        ListNode fourth = new ListNode(42);
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

//-------Implementing a Stack Using Linked Lists-------

       Stack stack = new Stack();
       stack.push(10);
       stack.push(21);
       stack.push(19);
       //System.out.println(stack.peek());
       //stack.pop();

      sll.insertAtPos(1, 3);
      sll.deleteAtPosition(2);
      System.out.println("List after deleting node after node with value 45");
      SinglyLinkedList.ListNode prevNode = second;
      sll.deleteAfterNode(prevNode);
      sll.searchNode(45);
      sll.show();

    }
}

class Stack {
    private ListNode top;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }

    public Stack(){
        top=null;
        length=0;
    }

    int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp=new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){
        int result=top.data;
        top=top.next;
        length--;
        return result;

    }

    public int peek(){
        return top.data;

    }
}