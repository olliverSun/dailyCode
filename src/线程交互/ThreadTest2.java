package 线程交互;

public class ThreadTest2 {

    public static void main(String[] args){
        Hreo a = new Hreo();
        for (int i = 0; i <5 ; i++) {
            new Thread(new Runnable() {
                @Override
                public  void run() {
                    while (true){
                        try {
                            a.hurt();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }


        for (int i = 0; i <2; i++) {
            new Thread(new Runnable() {
                @Override
                public  void run() {
                    while (true){
                        try {
                            a.recover();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }

    }
}
