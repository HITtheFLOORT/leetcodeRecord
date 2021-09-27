package Solution201to300;

import java.util.Arrays;

//O(n)
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;
        int sum=nums[0];
        int maxlen=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(sum<target){
                r++;
                sum+=nums[r];
            }
            while(sum>=target){
                maxlen=Math.min(maxlen,r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return maxlen==Integer.MAX_VALUE?0:maxlen;
    }
    //O(nlogn)
    public int minSubArrayLen_Binary(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
