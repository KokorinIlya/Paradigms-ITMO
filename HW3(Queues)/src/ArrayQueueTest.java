import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        int x;
        ArrayQueueADT queue1 = new ArrayQueueADT();
        ArrayQueue queue2 = new ArrayQueue();
        while (true){
            s = in.next();
            if (s.equals("AddTail")){
                x = in.nextInt();
                ArrayQueueModule.enqueue(x);
                ArrayQueueADT.enqueue(queue1, x);
                queue2.enqueue(x);
            }
            if (s.equals("AddHead")){
                x = in.nextInt();
                ArrayQueueModule.push(x);
                ArrayQueueADT.push(queue1, x);
                queue2.push(x);
            }
            if (s.equals("Clear")){
                ArrayQueueModule.clear();
                ArrayQueueADT.clear(queue1);
                queue2.clear();
            }
            if (s.equals("ShowHead")){
                System.out.println(ArrayQueueModule.element());
                System.out.println(ArrayQueueADT.element(queue1));
                System.out.println(queue2.element());

            }
            if (s.equals("ShowTail")){
                System.out.println(ArrayQueueModule.peek());
                System.out.println(ArrayQueueADT.peek(queue1));
                System.out.println(queue2.peek());
            }
            if (s.equals("DeleteHead")) {
                System.out.println(ArrayQueueModule.dequeue());
                System.out.println(ArrayQueueADT.dequeue(queue1));
                System.out.println(queue2.dequeue());
            }
            if (s.equals("DeleteTail")) {
                ArrayQueueModule.remove();
                ArrayQueueADT.remove(queue1);
                queue2.remove();
            }
            if (s.equals("Size")){
                System.out.println(ArrayQueueModule.size());
                System.out.println(ArrayQueueADT.size(queue1));
                System.out.println(queue2.size());
            }
            if (s.equals("IsEmpty")){
                System.out.println(ArrayQueueModule.isEmpty());
                System.out.println(ArrayQueueADT.isEmpty(queue1));
                System.out.println(queue2.isEmpty());
            }
            if (s.equals("Exit")){
                return;
            }
        }
    }
}
