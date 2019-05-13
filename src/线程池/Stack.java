package 线程池;

public interface Stack<E> {

     boolean put(E e);

     E poll();

     E pollLast();

     E get(int index);

     E get();

     int Size();

}
