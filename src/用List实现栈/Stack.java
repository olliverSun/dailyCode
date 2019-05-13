package 用List实现栈;

public interface Stack<E> {

     boolean put(E e);

     E poll();

     E pollLast();

     E get(int index);

     E get();

     int Size();

}
