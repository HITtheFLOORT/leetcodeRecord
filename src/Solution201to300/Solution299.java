package Solution201to300;

import java.util.HashMap;
import java.util.Map;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int A=0,B=0;
        Map<Character,Integer> ma=new HashMap();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                A++;
            }else{
                ma.put(secret.charAt(i),ma.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                int tmp=ma.getOrDefault(guess.charAt(i),0);
                if(tmp>0){
                    B++;
                    ma.put(guess.charAt(i),tmp-1);
                }
            }
        }
        return A+"A"+B+"B";
    }
}
