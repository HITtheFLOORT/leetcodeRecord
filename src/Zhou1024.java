public class Zhou1024 {
    public boolean check(String s){
        int numlink=0;
        if(s.length()<=0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                return false;
            }
            if(s.charAt(i)=='!'||s.charAt(i)=='.'||s.charAt(i)==','){
                if(i!=s.length()-1){
                    return false;
                }
            }
            if (s.charAt(i)=='-'){
                if(i==0|i==s.length()-1){
                    return false;
                }else if(!Character.isLetter(s.charAt(i-1))||!Character.isLetter(s.charAt(i+1))) {
                    return false;
                }else{
                    numlink++;
                }
            }
        }
        if(numlink>1){
            return false;
        }
        return true;
    }
    public int countValidWords(String sentence) {
        String s[]=sentence.split(" ");
        int ans=0;
        for(String letter:s){
            if(check(letter)){
                ans++;
            }
        }
        return ans;
    }

}
