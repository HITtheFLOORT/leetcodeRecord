package Solution201to300;

import java.util.*;

public class Solution211 {
    Map<Integer, Set<String>> hs=new HashMap<>();
    public void addWord(String word){
        Set<String> set=hs.getOrDefault(word.length(),new HashSet<>());
        set.add(word);
        hs.put(word.length(),set);
    }
    public boolean search(String word){
        Set<String> set=hs.get(word.length());
        if(set==null){
            return false;
        }
        if(set.contains(word)){
            return true;
        }
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!='.'){
                ls.add(i);
            }
        }
        if(ls.size()==0){
            return true;
        }
        for(String s:set){
            boolean flag=true;
            for(int index:ls){
                if(s.charAt(index)!=word.charAt(index)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}
