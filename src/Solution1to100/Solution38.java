package Solution1to100;

import java.util.HashMap;
import java.util.Map;

public class Solution38 {
    public String countAndSay(int n) {
        String ans="1";
        if(n==1){
            return ans;
        }else{
            for(int i=2;i<=n;i++){
                ans=getcountString(ans);
            }
        }
        return ans;
    }
    public String getcountString(String s){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int j=i+1;
            while(j<s.length()&&s.charAt(j)==s.charAt(i)){
                j++;
            }
            sb.append((j-i)+""+s.charAt(i));
            i=j-1;
        }
        return sb.toString();
    }
}
