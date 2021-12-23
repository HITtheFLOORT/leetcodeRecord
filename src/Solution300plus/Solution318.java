package Solution300plus;

public class Solution318 {
    public int maxProduct(String[] words) {
        int a[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            String tmp=words[i];
            for(int j=0;j<tmp.length();j++){
                int word=tmp.charAt(j)-'a';
                if((a[i]>>word&1)!=1) {
                    a[i]+=(1<<word);
                }
            }
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((a[i]&a[j])==0){
                  ans=Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}
