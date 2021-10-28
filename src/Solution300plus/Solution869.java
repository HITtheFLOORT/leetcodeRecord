package Solution300plus;

import java.util.HashSet;
import java.util.Set;

public class Solution869 {
    Set<String> pow2=new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        getpow2();
        return pow2.contains(count(n));
    }
    public void getpow2(){
        for(int i=1;i<1e9;i<<=1){
            pow2.add(count(i));
        }
    }
    public String count(int n){
        char[] ans=new char[10];
        while(n>0){
            ans[n%10]++;
            n/=10;
        }
        return new String(ans);
    }
}
