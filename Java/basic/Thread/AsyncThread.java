package basic.Thread;

import java.util.concurrent.CompletableFuture;

public class AsyncThread {

    public static void main(String[] args) {

        System.out.println("Main thread started");


        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> {

                    System.out.println("Fetching user data...");

                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return "User: Ashu";
                });


        userFuture.thenAccept(user -> {

            System.out.println("Received Data -> " + user);

        });


        // prevent main from exiting immediately
        userFuture.join();

        System.out.println("Program finished");
    }
}