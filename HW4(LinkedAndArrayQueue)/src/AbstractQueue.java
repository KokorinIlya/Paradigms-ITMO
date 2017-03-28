import java.util.function.Predicate;
import java.util.function.Function;

abstract public class AbstractQueue implements Queue {
    protected int size = 0;

    public void enqueue(Object element){
        assert element != null : "Element is null";
        addTail(element);
        size++;
    }

    abstract protected void addTail(Object element);

    public Object element(){
        assert size > 0 : "Queue is empty";
        return showHead();
    }

    abstract protected Object showHead();

    public Object dequeue(){
        assert size > 0 : "Queue is empty";
        Object result = element();
        deleteHead();
        size--;
        return result;
    }

    abstract protected void deleteHead();

    public void clear(){
        deleteAll();
        size = 0;
    }

    protected abstract void deleteAll();

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    abstract protected AbstractQueue makeCopy();

    public Queue filter(Predicate<Object> predicate) {
        assert predicate != null : "Predicate is null";
        Queue newQueue = makeCopy();
        int newSize = newQueue.size();
        for (int i = 0; i < newSize; i++) {
            Object element = newQueue.dequeue();
            if (predicate.test(element)) {
                newQueue.enqueue(element);
            }
        }
        return newQueue;
    }

    public Queue map(Function<Object, Object> function) {
        assert function != null : "Predicate is null";
        Queue newQueue = makeCopy();
        int newSize = newQueue.size();
        for (int i = 0; i < newSize; i++) {
            Object element = newQueue.dequeue();
            newQueue.enqueue(function.apply(element));
        }
        return newQueue;
    }
}
