package basic.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {
    public static void main(String []args){

        ExtendedThread extendedThread = new ExtendedThread("extendedThread");
        Thread implementedThread = new Thread(new ImplementedThread(), "implementedThread");

        implementedThread.start();
        extendedThread.run();
        implementedThread.run();
        extendedThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);


    }
}
