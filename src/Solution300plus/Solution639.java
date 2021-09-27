package Solution300plus;

public class Solution639 {
    static final int MOD=1000000007;
    public int numDecodings(String s){
        int n=s.length();
        long a=0,b=1,c=0;
        for(int i=1;i<=n;i++){
            c=b*check1digit(s.charAt(i-1));
            if(i>1){
                c=(c+a*check2digit(s.charAt(i-2),s.charAt(i-1)))%MOD;
            }
            a=b;
            b=c;
        }
        return (int)c;
    }
    public int check1digit(char ch){
        if(ch=='0'){
            return 0;
        }else{
            return ch=='*'?9:1;
        }
    }
    public int check2digit(char a,char b){
        if(a=='*'&&b=='*'){
            return 15;
        }
        if(a=='*'){
            return b<='6'?2:1;
        }
        if(b=='*'){
            if(a=='1'){
                return 9;
            }
            if(a=='2'){
                return 6;
            }
            return 0;
        }
        return (a!='0'&&(a-'0')*10+(b-'0')<=26)?1:0;
    }

}
