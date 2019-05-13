package 线程交互;

public class Hreo {

    public Integer flag=0;
    private Integer energy=3;
    public   String name;
    private  Integer hp=1000;


    public synchronized void hurt() throws InterruptedException {
            if(hp==1){
                System.out.println("stop get damage");
                this.wait();
            }
        if (hp > 1) {
            hp--;
            this.notify();
            System.out.println("get damage，hp："+hp);

        }
    }
    public synchronized void recover() throws InterruptedException {
            if(hp==1000){
                System.out.println("can not continue to recover ");
                this.wait();
            }
            if(hp<1000){
                hp++;
                this.notify();
                System.out.println("get recover，hp："+hp);
            }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 问题：当把发波变为0时，开始充能，充能期间，不能发波。充能完毕的一瞬间，
    public synchronized void fabo(){
        if(energy>0){
            energy--;
            System.out.println(3-energy);
        }
    }

    public void charge() throws InterruptedException {
            System.out.println("五秒充能");
            flag++;
            System.out.println(flag+"次充能");
            energy=energy+3;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }
}
