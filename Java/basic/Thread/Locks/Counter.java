package basic.Thread.Locks;

public class Counter {
    private  int count=0;

    public int getCount() {
        return count;
    }

    public synchronized void increaseCount(){
        count++;
    }
}
