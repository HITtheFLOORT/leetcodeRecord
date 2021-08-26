import java.util.*;

public class letcode {

    public static void main(String[] args) {
        Deque<Integer> de=new LinkedList<>();
        de.push(1);
        de.push(2);
        System.out.println(new MediaProblem().numRescueBoats(new int[]{3,2,2,1},3));
    }
}


