package Solution300plus;

import java.util.Arrays;

public class Solution453 {
    public int minMoves(int[] nums) {
        int res=0;
        int min= Arrays.stream(nums).min().getAsInt();
        for(int a:nums){
            res+=a-min;
        }
        return res;
    }
}
