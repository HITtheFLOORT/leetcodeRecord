package Solution300plus;

import java.util.HashMap;
import java.util.Map;

public class Solution677 {
    class MapSum {
        Map<String,Integer> ma;
        Map<String,Integer> pre;
        public MapSum() {
            ma=new HashMap<>();
            pre=new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta=val-pre.getOrDefault(key,0);
            pre.put(key,val);

            for(int i=0;i<key.length();i++){
                String tmp=key.substring(0,i+1);
                ma.put(tmp,ma.getOrDefault(tmp,0)+delta);
            }
        }

        public int sum(String prefix) {
            return ma.getOrDefault(prefix,0);
        }
    }
}
