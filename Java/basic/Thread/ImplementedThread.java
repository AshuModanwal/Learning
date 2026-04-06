package basic.Thread;

public class ImplementedThread implements Runnable{

    @Override
    public void run(){
        System.out.println("Thread running --> "+ Thread.currentThread().getName());
    }
}
