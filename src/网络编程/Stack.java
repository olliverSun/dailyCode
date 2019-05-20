package 网络编程;

public interface Stack<E> {

     boolean put(E e);

     E poll();

     E pollLast();

     E get(int index);

     E get();

      int Size();

}
