package 线程池;
//1、线程池：池：集合
//2、处理集合中的数据。若集合中没有数据，则wait，若有数据，则notify
//wait的代码层面时机是：每次抢到CPU执行机会都执行一次判断（若集合中数据能处理，则处理，若不能，则wait）
//notify的代码层面时机是：集合每次add任务时都会notify一次
//锁为集合
public class ThreadPool {
    //    可以将其整合为自己的线程池
    private Integer countConsumers=10;
    private Integer countProducer=10;
    private Stack stack = new ListStack();
    private  Worker consumer;
    private  Worker producer;


    public static void main(String[] args){
         Worker a = new Consumer("生产者");
         Worker b = new Producer("消费者");
         new ThreadPool(a,b).engine();
    }

    ThreadPool(int countConsumers,int countProducer, Worker consumer,Worker producer){
        if(!(consumer instanceof Worker||producer instanceof Worker))
        {
            throw new RuntimeException("Error to create ThreadPool,can not create ThreadPool with no wroker or producer");
        }
        this.countConsumers=countConsumers;
        this.countProducer=countProducer;
        this.consumer=consumer;
        this.producer=producer;
    }
    ThreadPool(Worker consumer,Worker producer){
        this.consumer=consumer;
        this.producer=producer;
    }

//  一个消费者
    public  void engine() {
        for (int i = 0; i <countConsumers ; i++) {
//         匿名内部类无法访问非Final修饰的局部变量。
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        consumer.work(stack);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        for (int i = 0; i <countProducer ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        producer.work(stack);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
