class DLLNode {
    int data;
    DLLNode next, prev;
    DLLNode(int val) {
        data = val;
        next = prev = null;
    }
}

public class DoublyLinkedList {
    private DLLNode head, tail;

    void insertAtBeginning(int val) {
        DLLNode n = new DLLNode(val);
        if (head == null) head = tail = n;
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    void insertAtEnd(int val) {
        DLLNode n = new DLLNode(val);
        if (tail == null) head = tail = n;
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void displayForward() {
        DLLNode c = head;
        while (c != null) {
            System.out.print(c.data + " ");
            c = c.next;
        }
        System.out.println();
    }

    void displayBackward() {
        DLLNode c = tail;
        while (c != null) {
            System.out.print(c.data + " ");
            c = c.prev;
        }
        System.out.println();
    }

    void deleteFirst() {
        if (head == null) return;
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast() {
        if (tail == null) return;
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void deleteByValue(int val) {
        DLLNode c = head;
        while (c != null && c.data != val) c = c.next;
        if (c == null) return;
        if (c == head) deleteFirst();
        else if (c == tail) deleteLast();
        else {
            c.prev.next = c.next;
            c.next.prev = c.prev;
        }
    }

    void deleteBeforeValue(int target) {
        DLLNode c = head;
        while (c != null && c.data != target) c = c.next;
        if (c == null || c == head) return;
        DLLNode del = c.prev;
        if (del == head) deleteFirst();
        else {
            del.prev.next = c;
            c.prev = del.prev;
        }
    }

    void deleteAfterValue(int target) {
        DLLNode c = head;
        while (c != null && c.data != target) c = c.next;
        if (c == null || c.next == null) return;
        DLLNode del = c.next;
        if (del == tail) deleteLast();
        else {
            c.next = del.next;
            del.next.prev = c;
        }
    }

    int findMin() {
        if (head == null) throw new RuntimeException("Empty list");
        int min = head.data;
        DLLNode c = head;
        while (c != null) {
            if (c.data < min) min = c.data;
            c = c.next;
        }
        return min;
    }

    int findMax() {
        if (head == null) throw new RuntimeException("Empty list");
        int max = head.data;
        DLLNode c = head;
        while (c != null) {
            if (c.data > max) max = c.data;
            c = c.next;
        }
        return max;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(20);
        dll.insertAtBeginning(10);

        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(5);
        dll.insertAtEnd(50);

        System.out.print("Forward: ");
        dll.displayForward();   
        System.out.print("Backward: ");
        dll.displayBackward();  

        dll.deleteFirst(); 
        dll.deleteLast();   

        dll.deleteByValue(20);

        dll.deleteBeforeValue(30); 

        dll.deleteAfterValue(20);

        System.out.println("Min: " + dll.findMin());
        System.out.println("Max: " + dll.findMax()); 

        // 📊 Time Complexity:
        // - Insert (begin/end): O(1)
        // - Delete (first/last): O(1)
        // - Delete by value / before/after: O(n)
        // - Min / Max: O(n)                    
    }
}