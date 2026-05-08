package basic.Thread;

public class WaitNotifyThread {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Waiting thread started");

                try {
                    System.out.println("Waiting for notification...");
                    lock.wait();

                    System.out.println("Waiting thread got notification!");

                } catch (InterruptedException e) {
                    System.out.println("Waiting thread interrupted while waiting");
                }
            }
        });

        Thread notifyThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notify thread started!");

                try {
                    System.out.println("Notify thread sleeping...");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    System.out.println("Notify thread interrupted while sleeping");
                }

                System.out.println("Sending notification...");
                lock.notify();
            }
        });

        waitingThread.start();

        Thread.sleep(1000);

        notifyThread.start();

        waitingThread.join();
        notifyThread.join();

        System.out.println("Main thread finished");
    }
}