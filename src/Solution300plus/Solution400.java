package Solution300plus;

public class Solution400 {
    public int findNthDigit(int n) {

        int d=1,count=9;
        while(n>(long)d*count){
            n-=d*count;
            d++;
            count*=10;
        }
        int index=n-1;
        int start=(int)Math.pow(10,d-1);
        int num=start+index/d;
        int digitindex=index%d;
        int digit=(num/(int)(Math.pow(10,d-digitindex-1)))%10;
        return digit;
    }

}
