package basic.Thread.Locks;

public class BankAccount {

    private int balance = 100;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() +
                " attempting to withdraw: "+amount);
        if(balance >= amount){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return;
            }
            balance -= amount;

            System.out.println(Thread.currentThread().getName() +
                    " withdrawal completed! ");
        }
        else{

            System.out.println(Thread.currentThread().getName() + " insufficient balance"
            );
        }
    }
    public void deposit(int amount){
        System.out.println(Thread.currentThread().getName() + " depositing amount: "+amount);
        balance += amount;
    }


    public static void main() throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() ->{
            account.withdraw(50);
        });


        Thread t2 = new Thread( () -> {
            account.withdraw(50);
        });

        Thread t3 = new Thread( () ->{
            account.withdraw(50);
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println(account.balance);
    }
}
