package testThread;

public class TestThread {
    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread t = new Thread(run,"t1");
        /*Thread t2 = new Thread(run,"t2");
        Thread t3 = new Thread(run,"t3");
        t.start();
        t2.start();
        t3.start();*/
        t.start();
        try {
            t.sleep(10000);
        }catch (InterruptedException e){

        }
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(t.isInterrupted());

    }

}

class MyThread implements Runnable{
    private int count = 5;
    @Override
    public void run() {
        while(true){
            count--;
            System.out.println("线程:"+Thread.currentThread().getName()+"--->"+count+",");
        }
    }
}