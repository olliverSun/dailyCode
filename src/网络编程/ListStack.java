package 网络编程;


import 网络编程.Stack;

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
    public synchronized E poll() {
        return container.poll();
    }

    @Override
    public synchronized E pollLast() {
        return  container.pollLast();
    }

    @Override
    public synchronized E get(int index) {
        return container.get(index);
    }

    @Override
    public synchronized E get() {
        return container.getFirst();
    }

    @Override
    public synchronized int  Size() {
        return container.size();
    }
}
