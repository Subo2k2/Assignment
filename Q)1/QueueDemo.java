class ArrayQueue {
    private int[] arr;
    private int front, rear, size;

    ArrayQueue(int cap) {
        arr = new int[cap];
        front = 0; rear = -1; size = 0;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }
        arr = newArr;
        front = 0;
        rear = size - 1;
    }

    void enqueue(int val) {
        if (size == arr.length) resize();
        rear = (rear + 1) % arr.length;
        arr[rear] = val;
        size++;
    }

    int dequeue() {
        if (size == 0) throw new RuntimeException("Queue empty");
        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return val;
    }

    int peek() { return arr[front]; }

    void display() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[(front + i) % arr.length] + " ");
        System.out.println();
    }

    int findMin() {
        int min = arr[front];
        for (int i = 0; i < size; i++) {
            int v = arr[(front + i) % arr.length];
            if (v < min) min = v;
        }
        return min;
    }

    int findMax() {
        int max = arr[front];
        for (int i = 0; i < size; i++) {
            int v = arr[(front + i) % arr.length];
            if (v > max) max = v;
        }
        return max;
    }
}

class QNode {
    int data;
    QNode next;
    QNode(int d) { data = d; }
}

class LinkedQueue {
    QNode front, rear;

    void enqueue(int val) {
        QNode n = new QNode(val);
        if (rear == null) front = rear = n;
        else {
            rear.next = n;
            rear = n;
        }
    }

    int dequeue() {
        if (front == null) throw new RuntimeException("Queue empty");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    int peek() { return front.data; }

    int findMin() {
        QNode c = front;
        int min = c.data;
        while (c != null) {
            if (c.data < min) min = c.data;
            c = c.next;
        }
        return min;
    }

    int findMax() {
        QNode c = front;
        int max = c.data;
        while (c != null) {
            if (c.data > max) max = c.data;
            c = c.next;
        }
        return max;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        aq.enqueue(10);
        aq.enqueue(20);
        aq.enqueue(30);
        System.out.println("Array queue full. Enqueuing 40 → triggers resize.");
        aq.enqueue(40); 

        System.out.print("Array Queue: ");
        aq.display();
        System.out.println("Min: " + aq.findMin() + ", Max: " + aq.findMax());

        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(10);
        lq.enqueue(20);
        lq.enqueue(30);
        lq.enqueue(40);

        System.out.println("Linked Queue Min: " + lq.findMin() + ", Max: " + lq.findMax());

        // Comparison:
        // - Array Queue:
        // - Enqueue: O(1) amortized (due to resize)
        // - Dequeue: O(1)
        // - Memory: contiguous, may waste space
        // - Linked Queue:
        // - Enqueue/Dequeue: O(1)
        // -  Memory: dynamic, extra pointer per node
    }
}