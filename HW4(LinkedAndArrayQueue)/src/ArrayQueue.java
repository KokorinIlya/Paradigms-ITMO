public class ArrayQueue extends AbstractQueue {
    private int tail = 0, head = 0;

    private Object[] elements = new Object[10];

    private void ensureCapacity() {
        if (size() < elements.length) {
            return;
        }
        Object[] newElements = new Object[size() * 2];
        /*for (int j = 0, i = head; j < size(); i = next(i), j++) {
            newElements[j] = elements[i];
        }*/
        if (head < tail){
            System.arraycopy(elements, head, newElements, 0, size());
        }
        else{
            int size1 = elements.length - head;
            System.arraycopy(elements, head, newElements, 0, size1);
            int size2 = size() - size1;
            System.arraycopy(elements, 0,newElements, size1, size2);
        }
        elements = newElements;
        head = 0;
        tail = head + size();
    }

    private int next(int x){
        return (x + 1) % elements.length;
    }

    public void addTail(Object element) {
        ensureCapacity();
        elements[tail] = element;
        tail = next(tail);
    }

    protected Object showHead() {
        return elements[head];
    }

    protected void deleteHead() {
        elements[head] = null;
        head = next(head);
    }

    protected void deleteAll() {
        head = tail = 0;
    }

    protected ArrayQueue makeCopy(){
        ArrayQueue newQueue = new ArrayQueue();
        for (int j = 0, i = head; j < size(); i = next(i), j++) {
            Object element = elements[i];
            newQueue.enqueue(element);
        }
        return newQueue;
    }
}
