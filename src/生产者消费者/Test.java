package 生产者消费者;

public class Test {

    public static void main(String[] args){
        Stack stack = new ListStack();
//      一个消费者一个线程 并非三个消费者一个线程
        for(int i=1;i<4;i++){
            Cusuomer c1 = new Cusuomer(i+"号消费者");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        c1.work(stack);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
//        同样一个生产者一个线程，而非两个生产者一个线程
//        当一个生产者生产到达200时，会释放锁，唤醒其他线程，这时也会唤醒其他线程
//        这时候另外的生产者可能抢到锁，其他生产者抢到锁之后也会释放锁。
            for (int i = 1; i < 3; i++){
            Producer p2 = new Producer(i+"号生产者");
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        p2.work(stack);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
