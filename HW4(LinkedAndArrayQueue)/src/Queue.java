import java.util.function.Predicate;
import java.util.function.Function;

public interface Queue {
    //Pre: true
    public int size();
    //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = size

    //Pre: true
    public boolean isEmpty();
    //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = (size == 0)

    //Pre: e != null
    public void enqueue(Object element);  // добавление элемента в конец (tail) очереди
    // Post: size' = size + 1 && elements[size]' = e && elements[i]' = elements[i], 0 <= i < size

    //Pre: size > 0
    public Object element(); //вернуть элемент из начала (head) очереди
    //Post: size' = size && elements[i]' = elements[i], 0 <= i < size && R = elements[0]

    //Pre: size > 0
    public Object dequeue(); // удалить и вернуть элемент из начала (head) очереди
    //Post: size' = size - 1 && R = elements[0] && elements[i]' = elements[i + 1], 0 <= i < size'

    //Pre: true
    public void clear();
    //Post: size' = 0

    //Pre: predicate != null
    public Queue filter(Predicate<Object> predicate);
    //Post: size' <= size && 0 <= i[0] < i[1] < ... < i[size' - 1] < size &&
    // && set = (i[0], i[1],..., i[size' - 1])
    // && predicate(elements[j]) = true, j in set &&
    // && predicate(elements[j]) = false, j not in set, 0 <= j < size &&
    // && R = {elements[i[0]], elements[i[1]],..., elements[i[size' - 1]]}

    //Pre: function != null
    public Queue map(Function<Object, Object> function);
    //Post: size' = size && elements[i]' = function(elements[i]), 0 <= i < size &&
    // && R = {elements[0]', elements[1]',..., elements[size - 1]'}
}
