package Solution300plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class Solution911 {
    class TopVotedCandidate {
        List<Integer> tops=new ArrayList<>();
        Map<Integer,Integer> voteCounts=new HashMap<>();
        int [] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            voteCounts.put(-1,-1);
            int top=-1;
            for(int i=0;i<persons.length;i++){
                int p=persons[i];
                voteCounts.put(p,voteCounts.getOrDefault(p,0)+1);
                if(voteCounts.get(p)>=voteCounts.get(top)){
                    top=p;
                }
                tops.add(top);
            }
        }

        public int q(int t) {
            int l=0,r=times.length-1;
            while(l<r){
                int m=1+(r-l+1)/2;
                if(times[m]<=t){
                    l=m;
                }else{
                    r=m-1;
                }
            }
            return tops.get(l);
        }
    }
}
