package Solution101to200;

public class Solution152 {
    public int maxProduct(int[] nums){
        int n=nums.length;
        int ans=nums[0];
        int maxa,maxa1=nums[0],mina,mina1=nums[0];
        for(int i=1;i<n;i++){
            maxa=Math.max(maxa1*nums[i],Math.max(nums[i],mina1*nums[i]));
            mina=Math.min(mina1*nums[i],Math.min(nums[i],maxa1*nums[i]));
            maxa1=maxa;
            mina1=mina;
            ans=Math.max(ans,maxa);
        }
       return ans;
    }
}
