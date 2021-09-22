package Solution201to300;

public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int pos=0;
        while(left<right){
            left>>=1;
            right>>=1;
            pos++;
        }
        return left<<pos;
    }
}
