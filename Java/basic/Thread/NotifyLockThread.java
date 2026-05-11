package basic.Thread;


public class NotifyLockThread {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread waitingThread = new Thread(() -> {

            synchronized (lock) {

                System.out.println("Waiting thread waiting...");

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Waiting thread resumed!");
            }
        });

        Thread notifierThread = new Thread(() -> {

            synchronized (lock) {

                System.out.println("Notifier thread notifying...");

                lock.notify();

                System.out.println("Notifier still holding lock...");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Notifier releasing lock");
            }
        });

        waitingThread.start();

        Thread.sleep(1000);

        notifierThread.start();
    }
}