package basic.Thread;

public class SleepAndInterruptedThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{

            System.out.println("Thread Started");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.out.println("Thread Interrupted During Sleep");

                return;
            }
            System.out.println("Thread Completed!");

        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
        t1.join();
        System.out.println("Thread interrupted!");
    }
}