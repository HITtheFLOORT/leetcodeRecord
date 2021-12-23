package Solution300plus;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution630 {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->(b-a));
        int total=0;
        for(int c[]:courses){
            int ti=c[0],di=c[1];
            if(total+ti<=di){
                total+=ti;
                q.offer(ti);
            }else if(!q.isEmpty()&&q.peek()>ti){
                total-=q.poll()-ti;
                q.offer(ti);
            }
        }
        return q.size();
    }
}
