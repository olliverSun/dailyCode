package 线程池;

import org.junit.Test;



public class Producer implements Worker{

    private String name;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Producer(String name){
        this.name=name;
    }
    @Test
    public  void work(Stack stack) throws InterruptedException {
        while(true){
        synchronized(stack){
                if(stack.Size() >=200)
                    stack.wait();
//              wait语句出现之后，后面通常会再次验证抢到锁之后该怎么处理：
//            这里是关键
            if(stack.Size() <200){
                char a =65;
                char goal =(char)(a+(Math.random()*100*0.27));
                System.out.println(name+"压入: "+goal);
                stack.put(goal);
                stack.notify();
            }

            }
        }


    }


}
