import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lamdaexample {
    public void thread_example(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("...");
            }
        });
        new Thread(()->{System.out.println("...");});
    }
    public void sort_example(){
        ArrayList<String> l=new ArrayList();
        l.add("aa");
        l.add("a");
        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Collections.sort(l,(o1,o2)->{return o1.length()-o2.length();});
    }
}
