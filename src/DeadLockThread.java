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
    public void triger_lock()throws Exception {
        Lock lock1 = new Lock("[锁1]");
        Lock lock2 = new Lock("[锁2]");

        Thread thread1 = new DeadLockThread(lock1, lock2);
        thread1.setName("<线程1>");
        Thread thread2 = new DeadLockThread(lock2, lock1);
        thread2.setName("<线程2>");
        thread1.start();
        thread2.start();
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
