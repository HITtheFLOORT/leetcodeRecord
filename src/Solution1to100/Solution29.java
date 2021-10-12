package Solution1to100;

public class Solution29 {
    public int divide(int b,int a){
        // 考虑被除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            if (a == 1) {
                return Integer.MIN_VALUE;
            }
            if (a == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            return b == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (b == 0) {
            return 0;
        }
        boolean rev=false;
        if(b>0){
            b=-b;
            rev=!rev;
        }
        if(a>0){
            a=-a;
            rev=!rev;
        }
        int l=1,r=Integer.MAX_VALUE,ans=0;
        while(l<=r){
            int mid=l+((r-l)/2);
            boolean check = quickAdd(a, mid, b);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }
    public boolean quickAdd(int y,int z,int x){
        // 需要判断 z * y >= x 是否成立
        int res=0,add=y;
        while(z!=0){
            if((z&1)!=0){
                if(res<x-add){
                    return false;
                }
                res+=add;
            }
            if(z!=1){
                if(add<x-add){
                    return false;
                }
                add+=add;
            }
            z>>=1;
        }
        return true;
    }
}
