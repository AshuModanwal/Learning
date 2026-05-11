package basic.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 10; i++) {
            int finalI = i;

            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println("Factorial of " + finalI + " = " + result);
            });
        }

        executor.shutdown(); // stop accepting new tasks

        try {
            // WAIT PROPERLY UNTIL ALL TASKS FINISH
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // force stop if needed
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Total time: " + (endTime - startTime) + " ms");
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(5000); // simulate heavy task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}