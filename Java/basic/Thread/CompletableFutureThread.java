package basic.Thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThread {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> future = new CompletableFuture<>();


        // Waiting Task
        Thread waitingThread = new Thread(() -> {

            System.out.println("Waiting thread started");
            System.out.println("Waiting for result...");

            try {

                // waits until future is completed
                String result = future.get();

                System.out.println("Received result: " + result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        // Notifier Task
        Thread producerThread = new Thread(() -> {

            System.out.println("Producer thread started");

            try {

                System.out.println("Producer doing some work...");
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Completing future...");

            // similar to notify()
            future.complete("Task Completed Successfully");
        });


        waitingThread.start();

        Thread.sleep(1000);

        producerThread.start();


        waitingThread.join();
        producerThread.join();

        System.out.println("Main thread finished");
    }
}