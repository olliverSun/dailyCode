package 生产者消费者;




public class Cusuomer {

    String name;

    public Cusuomer(String name) {
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
