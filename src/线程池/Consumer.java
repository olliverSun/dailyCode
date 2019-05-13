package 线程池;




public class Consumer implements Worker{

    String name;

    public Consumer(String name) {
     this.name=name;
    }

    public  void work(Stack stack) throws InterruptedException {
        while(true){
        synchronized(stack){

                if(stack.Size()<=0)
                    stack.wait();
                if(stack.Size()>0)
                System.out.println(name+"弹出："+stack.poll());
                stack.notify();
            }
        }

    }
}
