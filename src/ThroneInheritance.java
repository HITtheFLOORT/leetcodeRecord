import java.util.*;

public class ThroneInheritance {
    Map<String, List<String>> edges;
    Set<String> dead;
    String king;
    public ThroneInheritance(String king){
        this.edges=new HashMap<>();
        this.dead=new HashSet<>();
        this.king=king;
    }
    public void birth(String p,String c){
        List<String> children=edges.getOrDefault(p,new ArrayList<String>());
        children.add(c);
        edges.put(p,children);
    }
    public void death(String name){
        dead.add(name);
    }
    public List<String> getInheritanceOrder(){
        List<String> ans=new ArrayList<>();
        preoder(ans,king);
        return ans;
    }
    private void preoder(List<String> ans,String name){
        if(!dead.contains(name)){
            ans.add(name);
        }
        List<String> children=edges.getOrDefault(name,new ArrayList<String>());
        for(String s:children){
            preoder(ans,s);
        }
     }
    public int[][] merge(int[][] intervals) {
        BitSet bitSet=new BitSet();
        int max=0;
        for(int[] a:intervals){
            int tmp=a[1]*2+1;
            bitSet.set(a[0]*2,tmp,true);
            max=tmp>=max?tmp:max;
        }
        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }


}
