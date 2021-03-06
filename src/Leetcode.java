import Solution300plus.Solution318;

import java.util.HashMap;
import java.util.Scanner;

public class Leetcode {
    public boolean isPerfectSquare(int num) {
        int l=1,r=num/2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid*mid==num){
                return true;
            }
            if(mid*mid<num){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException {
        HashMap<String,Integer> ma=new HashMap<>();
        System.out.println(new Solution318().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        TokenBucket tokenBucket = new TokenBucket(1D, 1);
        for (int i=0; i<10; i++) {
            System.out.println(tokenBucket.acquire(1));
            Thread.sleep(500);
        }
    }
}
