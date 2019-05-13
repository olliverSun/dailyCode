package 线程池;

public interface Worker {

    public void work(Stack stack)throws InterruptedException;
}
