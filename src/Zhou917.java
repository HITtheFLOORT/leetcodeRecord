public class Zhou917 {
    public String reversePrefix(String word, char ch) {
        int index=word.indexOf(ch);
        if (index==-1){
            return word;
        }
        char s[]=word.toCharArray();
        for(int i=0;i<=index;i++){
            char tmp=s[i];
            s[i]=s[index-i];
            s[index-i]=tmp;
        }
        return new String(s);
    }
}
