public class ArrayQueueADT {
    //INV: size >= 0 && elements[i] != null, 0 <= i < size
    private int size = 0;
    private int head = 0, tail = 0;
    private Object[] elements = new Object[2];

    public static int size(ArrayQueueADT queue) {
        //Pre: queue != null
        return queue.size;
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = size
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        //Pre: queue != null
        return queue.size == 0;
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = (size == 0)
    }

    private static int next(ArrayQueueADT queue, int x) {
        return (x + 1) % queue.elements.length;
    }

    private static int prev(ArrayQueueADT queue, int x) {
        return (x + queue.elements.length - 1) % queue.elements.length;
    }

    private static void ensureCapacity(ArrayQueueADT queue) {
        if (size(queue) < queue.elements.length) {
            return;
        }
        Object[] newElements = new Object[size(queue) * 2];
        for (int j = 0, i = queue.head; j < size(queue); i = next(queue, i), j++) {
            newElements[j] = queue.elements[i];
        }
        queue.elements = newElements;
        queue.head = 0;
        queue.tail = queue.head + size(queue);
    }

    public static void enqueue(ArrayQueueADT queue, Object element) { // добавление элемента в конец (tail) очереди
        //Pre: e != null && queue != null
        assert element != null : "Element is null";
        ensureCapacity(queue);
        queue.elements[queue.tail] = element;
        queue.tail = next(queue, queue.tail);
        queue.size++;
        //Post: size' = size + 1 && elements[size]' = e && elements[i]' = elements[i], 0 <= i < size
    }

    public static void push(ArrayQueueADT queue, Object element) { //добавление в начало (head)
        //Pre: e != null && queue != null
        assert element != null : "Element is null";
        ensureCapacity(queue);
        queue.elements[prev(queue, queue.head)] = element;
        queue.head = prev(queue, queue.head);
        queue.size++;
        //Post: size' = size + 1, elements[0]' = e, elements[i + 1]' = elements[i], 0 <= i < size
    }

    public static Object element(ArrayQueueADT queue) { //вернуть элемент из начала (head) очереди
        //Pre: size > 0 && queue != null
        assert queue.size > 0 : "Queue is empty";
        return queue.elements[queue.head];
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = elements[0]
    }

    public static Object peek(ArrayQueueADT queue) { //Вернуть элемент из конца (tail)
        //Pre: size > 0 && queue != null
        assert queue.size > 0 : "Queue is empty";
        return queue.elements[prev(queue, queue.tail)];
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = elements[size - 1]
    }

    public static Object dequeue(ArrayQueueADT queue) { // удалить и вернуть элемент из начала (head) очереди
        //Pre: size > 0 && queue != null
        assert queue.size > 0 : "Queue is empty";
        Object result = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = next(queue, queue.head);
        queue.size--;
        return result;
        //Post: size' = size - 1 && R = elements[0] && elements[i]' = elements[i + 1], 0 <= i < size'
    }

    public static Object remove(ArrayQueueADT queue) { //удалить элемент из конца (tail)
        //Pre: size > 0 && queue != null
        assert queue.size > 0 : "Queue is empty";
        Object result = queue.elements[prev(queue, queue.tail)];
        queue.tail = prev(queue, queue.tail);
        queue.size--;
        return result;
        //Post: size' = size - 1 && elements[i]' = elements[i], 0 <= i < size'
    }

    public static void clear(ArrayQueueADT queue) {
        //Pre: queue != null
        queue.size = 0;
        queue.head = queue.tail = 0;
        Object newElements[] = new Object[2];
        queue.elements = newElements;
        //Post: size' = 0
    }
}
