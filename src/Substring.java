import java.lang.reflect.Array;
import java.util.*;

public class Substring {
    public String removeDuplicateLetters(String s) {
        /*
        给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
         */
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {//确保唯一最先出现的字母
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {//找最小字母
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {// 确保字母未出现
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                        //System.out.println(sb);
                    } else {
                        break;
                    }
                }
                //System.out.println();
                vis[ch - 'a'] = true;
                sb.append(ch);
                //System.out.println(sb);
                //System.out.println();
            }
            num[ch - 'a'] -= 1;//确保所有字母都用过
        }
        return sb.toString();

    }

    public char findTheDifference(String s, String t) {
        /*
        给定两个字符串 s 和 t，它们只包含小写字母。

        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

        请找出在 t 中被添加的字母。
         */
        int ch[]=new int[26];
        for(int i=0;i<s.length();i++){
            if((int)(s.charAt(i)-'a')<26){
                ch[(int)(s.charAt(i)-'a')]++;
                //System.out.println((int)(s.charAt(i)-'a'));
            }
        }
        for(int i=0;i<t.length();i++){
            if((int)(t.charAt(i)-'a')<26){
                ch[(int)(t.charAt(i)-'a')]--;
                //System.out.println((int)(s.charAt(i)-'a'));
            }
        }
        char ans='a';
        for(int i=25;i>=0;i--){
            if(ch[i]<0){
                ans=(char)(i+'a');
                break;
            }
        }
        return ans;
    }
    public int firstUniqChar(String s) {
    /*
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */
        int a[]=new int[26];
        int pos[]=new int[26];
        for(int i=0;i<26;i++){
            pos[i]=-1;
        }
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
            if(a[s.charAt(i)-'a']==1){
                pos[s.charAt(i)-'a']=i;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(pos[i]>-1){
                if(a[i]==1){
                    if(pos[i]<min)min=pos[i];
                }
            }
        }
        if(min>=26){
            return -1;
        }
        else{
            return min;
        }
    }
    public int minDeletions(String s) {
        /*
        给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。

        字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。

         */
        int[] a = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) a[c - 'a'] ++;// 统计字母个数

        Set<Integer> h = new HashSet<Integer>();
        int res = 0;
        for (int i : a) {
            if (i != 0) {               // 有数目才进行判断
                while (h.contains(i)) { // set已经包含就自减
                    i --;
                    res ++;
                }
                if (i != 0) h.add(i);   // 自减到0时，表示完全删除了某个字母，不能加入set中
            }
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        Map<Character,Integer> ma=new HashMap();
        for(int i=0,j=0;j<s.length();j++){
            if(ma.containsKey(s.charAt(j))){
                i = Math.max(ma.get(s.charAt(j)), i);
            }
            result=Math.max(result,j-i+1);
            ma.put(s.charAt(j),j+1);
        }
        return result;
    }
    public String removeduplicates(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(st.peek()==s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        while(!st.isEmpty()){
            stringBuffer.append(st.pop());
        }
        return stringBuffer.reverse().toString();
    }
}
