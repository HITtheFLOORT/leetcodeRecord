import java.util.HashMap;

public class Zhou1003 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int ans[][]=new int[m][n];
        int num=original.length;
        if(m*n>num){
            return new int[0][0];
        }
        for(int i=0;i<m*n;i++){
            ans[i/n][i%n]=original[i];
        }
        return ans;
    }
    public int numOfPairs(String[] nums, String target) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    if((nums[i]+nums[j]).equals(target)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public int waysToPartition(int[] nums, int k) {
       int sum[]=new int[nums.length];
       sum[0]=nums[0];
       int n=nums.length;
       for(int i=1;i<n;i++){
           sum[i]=sum[i-1]+nums[i];
       }
       int ans0=0;
       if(sum[n-1]%2==0){
           for(int i=1;i<n;i++){
               if(sum[i]==sum[n-1]/2){
                   ans0++;
               }
           }
       }
      int ans1=0;
        HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=1;i<n;i++){
            map.put(sum[i],map.getOrDefault(sum[i],1));
       }
       for(int value:map.values()){
           ans1=Math.max(ans1,value);
       }
        return Math.max(ans1,ans0);
    }
}
