public class ArrayQueueModule {
    //INV: size >= 0 && elements[i] != null, 0 <= i < size
    private static int size = 0;
    private static int head = 0, tail = 0;
    private static Object[] elements = new Object[2];

    public static int size() {
        //Pre: true
        return size;
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = size
    }

    public static boolean isEmpty() {
        //Pre: true
        return size == 0;
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = (size == 0)
    }

    private static int next(int x) {
        return (x + 1) % elements.length;
    }

    private static int prev(int x) {
        return (x + elements.length - 1) % elements.length;
    }

    private static void ensureCapacity() {
        if (size() < elements.length) {
            return;
        }
        Object[] newElements = new Object[size() * 2];
        for (int j = 0, i = head; j < size(); i = next(i), j++) {
            newElements[j] = elements[i];
        }
        elements = newElements;
        head = 0;
        tail = head + size();
    }

    public static void enqueue(Object element) { // добавление элемента в конец (tail) очереди
        //Pre: e != null
        assert element != null : "Element is null";
        ensureCapacity();
        elements[tail] = element;
        tail = next(tail);
        size++;
        //Post: size' = size + 1 && elements[size]' = e && elements[i]' = elements[i], 0 <= i < size
    }

    public static void push(Object element) { //добавление в начало (head)
        //Pre: e != null
        assert element != null : "Element is null";
        ensureCapacity();
        elements[prev(head)] = element;
        head = prev(head);
        size++;
        //Post: size' = size + 1, elements[0]' = e, elements[i + 1]' = elements[i], 0 <= i < size
    }

    public static Object element() { //вернуть элемент из начала (head) очереди
        //Pre: size > 0
        assert size > 0 : "Queue is empty";
        return elements[head];
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = elements[0]
    }

    public static Object peek() { //Вернуть элемент из конца (tail)
        //Pre: size > 0
        assert size > 0 : "Queue is empty";
        return elements[prev(tail)];
        //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = elements[size - 1]
    }

    public static Object dequeue() { // удалить и вернуть элемент из начала (head) очереди
        //Pre: size > 0
        assert size > 0 : "Queue is empty";
        Object result = elements[head];
        elements[head] = null;
        head = next(head);
        size--;
        return result;
        //Post: size' = size - 1 && R = elements[0] && elements[i]' = elements[i + 1], 0 <= i < size'
    }

    public static Object remove() { //удалить элемент из конца (tail)
        //Pre: size > 0
        assert size > 0 : "Queue is empty";
        Object result = elements[prev(tail)];
        tail = prev(tail);
        size--;
        return result;
        //Post: size' = size - 1 && elements[i]' = elements[i], 0 <= i < size'
    }

    public static void clear() {
        //Pre: true
        size = 0;
        head = tail = 0;
        Object newElements[] = new Object[2];
        elements = newElements;
        //Post: size' = 0
    }
}
