import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class letcode {//5 5

    public static void main(String[] args) throws Exception {
        Lock lock1 = new Lock("[锁1]");
        Lock lock2 = new Lock("[锁2]");

        Thread thread1 = new DeadLockThread(lock1, lock2);
        thread1.setName("<线程1>");
        Thread thread2 = new DeadLockThread(lock2, lock1);
        thread2.setName("<线程2>");
        thread1.start();
        thread2.start();
    }
}
