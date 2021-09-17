class Lock{
    String name;
    Lock(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
}

public class DeadLockThread extends Thread{

    private final Lock lock1;
    private final Lock lock2;

    public DeadLockThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "先拿" + lock1.getName() + "，然后尝试获取锁" + lock2.getName());
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "获取到锁" + lock2.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
