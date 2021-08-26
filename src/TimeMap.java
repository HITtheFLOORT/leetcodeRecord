import java.util.ArrayList;
import java.util.HashMap;

public class TimeMap {
    HashMap<String,ArrayList<Integer>> map=new HashMap();
    HashMap<String,String> res=new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Integer> ks=map.getOrDefault(key,new ArrayList<>());
        ks.add(timestamp);
        map.put(key,ks);
        res.put(key+timestamp,value);

    }

    public String get(String key, int timestamp) {
        ArrayList<Integer> ls= map.getOrDefault(key,new ArrayList<>());
        int n=ls.size();
        int l=0;
        int r=n-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(ls.get(mid)>timestamp){
                r=mid-1;
            }else{
                ans=ls.get(l);
                l=mid+1;
            }
        }
        if(ans!=-1){
            return res.get(key+ans);
        }
        return null;
    }

}
