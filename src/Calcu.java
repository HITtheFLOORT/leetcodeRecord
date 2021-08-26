import java.util.Deque;
import java.util.LinkedList;

public class Calcu {
    public int calculate2(String s) {//计算器括号
        Deque<Integer> de=new LinkedList<>();
        int sign=1;
        int result=0;
        de.push(sign);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){

            }else if(s.charAt(i)=='+'){
                sign=de.peek();
            }else if(s.charAt(i)=='-'){
                sign=-de.peek();
            }else if (s.charAt(i) == '(') {
                de.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                de.pop();
                i++;
            } else {
                long num=0;
                for(;i<s.length()&&Character.isDigit(s.charAt(i));i++){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result+=sign*num;
            }
        }
        return result;
    }
    public int calculate(String s) {//计算器简单乘除
        Deque<Character> de=new LinkedList<>();
        Deque<Integer> num=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){

            }else if(s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='-'){
                de.push(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))){
                if(!de.isEmpty()&&de.peek()=='*'){
                    de.pop();
                    int a=0;
                    for(;i<s.length()&&Character.isDigit(s.charAt(i));i++){
                        a = a * 10 + s.charAt(i) - '0';
                    }
                    i--;
                    int b= num.pop();
                    num.push(a*b);
                }else if(!de.isEmpty()&&de.peek()=='/'){
                    de.pop();
                    int a=0;
                    for(;i<s.length()&&Character.isDigit(s.charAt(i));i++){
                        a = a * 10 + s.charAt(i) - '0';
                    }
                    i--;
                    int b= num.pop();
                    num.push(b/a);
                }else if(!de.isEmpty()&&de.peek()=='-'){
                    de.pop();
                    int a=0;
                    for(;i<s.length()&&Character.isDigit(s.charAt(i));i++){
                        a = a * 10 + s.charAt(i) - '0';
                    }
                    i--;
                    num.push(0-a);
                }else {
                    int a=0;
                    for(;i<s.length()&&Character.isDigit(s.charAt(i));i++){
                        a = a * 10 + s.charAt(i) - '0';
                    }
                    i--;
                    num.push(a);
                }
            }
        }
        int res=0;
        while(!num.isEmpty()){
            res+= num.pop();
        }
        return res;
    }
}
