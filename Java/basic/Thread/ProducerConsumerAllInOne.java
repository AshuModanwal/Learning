package basic.Thread;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/* ==============================
   1. WAIT / NOTIFY VERSION
   ============================== */
class SharedResource {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {

        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        data = value;
        hasData = true;

        System.out.println("[Wait/Notify] Produced: " + value);

        notifyAll();
    }

    public synchronized int consume() {

        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        hasData = false;

        System.out.println("[Wait/Notify] Consumed: " + data);

        notifyAll();

        return data;
    }
}

/* ==============================
   2. BLOCKINGQUEUE VERSION
   ============================== */
class QueueResource {

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public void produce(int value) {
        try {
            queue.put(value); // waits automatically if full
            System.out.println("[BlockingQueue] Produced: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void consume() {
        try {
            int value = queue.take(); // waits automatically if empty
            System.out.println("[BlockingQueue] Consumed: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/* ==============================
   MAIN CLASS
   ============================== */
public class ProducerConsumerAllInOne {

    public static void main(String[] args) {

        System.out.println("===== WAIT / NOTIFY DEMO =====");

        SharedResource resource = new SharedResource();

        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.produce(i);
            }
        });

        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.consume();
            }
        });

        producer1.start();
        consumer1.start();


        try {
            producer1.join();
            consumer1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.println("\n===== BLOCKINGQUEUE DEMO =====");

        QueueResource queueResource = new QueueResource();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                queueResource.produce(i);
                sleep(200);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                queueResource.consume();
                sleep(300);
            }
        });

        executor.shutdown();
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}