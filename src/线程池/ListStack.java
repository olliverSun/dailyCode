package 线程池;


import java.util.ArrayList;
import java.util.LinkedList;

public class ListStack<E> implements Stack<E> {
    LinkedList<E> container =new LinkedList<E>();

    @Override
    public synchronized  boolean put(E e) {
        boolean flag =container.add(e);
          this.notify();
        return flag;
    }

    @Override
//
    public E poll() {
        return container.poll();
    }

    @Override
    public E pollLast() {
        return  container.pollLast();
    }

    @Override
    public E get(int index) {
        return container.get(index);
    }

    @Override
    public E get() {
        return container.getFirst();
    }

    @Override
    public int Size() {
        return container.size();
    }
}
