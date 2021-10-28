package Solution300plus;

import java.util.ArrayList;
import java.util.List;

public class Solution301 {
    List<String> res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lr=0,rr=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lr++;
            }else if(s.charAt(i)==')'){
                if(lr==0){
                    rr++;
                }else{
                    lr--;
                }
            }
        }
        helper(s,0,0,0,lr,rr);
        return res;
    }
    public void helper(String str,int start, int lc,int rc,int lr,int rr){
        if(lr==0&&rr==0){
            if(isValid(str)){
                res.add(str);
            }
        }else{
            for(int i=start;i<str.length();i++){
                if(i!=start&&str.charAt(i)==str.charAt(i-1)){
                    if(str.charAt(i)=='('){
                        lc++;
                    }else if(str.charAt(i)==')'){
                        rc++;
                    }
                    continue;
                }
                if(lr+rr> str.length()-i){
                    return;
                }
                if(lr>0&&str.charAt(i)=='('){
                    helper(str.substring(0,i)+str.substring(i+1),i,lc,rc,lr-1,rr);
                }
                if(rr>0&&str.charAt(i)==')'){
                    helper(str.substring(0,i)+str.substring(i+1),i,lc,rc,lr,rr-1);
                }
                if(str.charAt(i)=='('){
                    lc++;
                }else if(str.charAt(i)==')'){
                    rc++;
                }
                if(rc>lc){
                    break;
                }
            }
        }
    }
    public boolean isValid(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
            }
            if(s.charAt(i)==')'){
                c--;
            }
            if(c<0){
                return false;
            }
        }
        return c==0;
    }
}
