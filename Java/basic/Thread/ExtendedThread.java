package basic.Thread;

public class ExtendedThread extends Thread{

    public ExtendedThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Thread running ---> "+ Thread.currentThread().getName());
    }

}
