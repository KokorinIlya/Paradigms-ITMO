public class LinkedQueue extends AbstractQueue {
    private class Node {
        Object value;
        Node next;

        private Node(Object value) {
            assert value != null;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void addTail(Object element) {
        Node newNode = new Node(element);
        if (size == 0) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    protected Object showHead() {
        return head.value;
    }

    protected void deleteHead() {
        if (size == 1){
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    protected void deleteAll() {
        head = tail = null;
    }

    public LinkedQueue makeCopy() {
        LinkedQueue copyQueue = new LinkedQueue();
        Node node = head;
        while (node != null) {
            copyQueue.enqueue(node.value);
            node = node.next;
        }
        return copyQueue;
    }
}
