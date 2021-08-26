import java.util.Arrays;
import java.util.HashSet;

public class Zhou822 {
    public  int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }
    public int findGCD(int[] nums) {
        int max= Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        return gcd(max,min);
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i< nums.length;i++){
            hs.add(Integer.parseInt(nums[i],2));
        }
        for(int i=0;i<Math.pow(2,n);i++){
            if(!hs.contains(i)){
                String s=Integer.toBinaryString(i);
                return tobinary(i,n);
            }
        }
        return tobinary(0,n);
    }
    public String tobinary(int x,int digit){
        String cover=Integer.toBinaryString(1<<digit).substring(1);
        String s=Integer.toBinaryString(x);
        return s.length()<digit?cover.substring(s.length())+s:s;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;

        int dpLen = 5000;
        int[] dp = new int[dpLen];

        for (int i = 0; i < m; i++) {
            if(i == 0){
                for (int j = 0; j < n; j++) {
                    dp[mat[i][j]] = 1;
                }
            } else {
                int[] tmpDp = new int[dpLen];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < dpLen; k++) {
                        if(dp[k] == 1){
                            tmpDp[mat[i][j] + k] = 1;
                        }
                    }
                }
                dp = tmpDp;
            }
        }

        int gap = 0;
        while (true){
            if(target - gap >= 0 && dp[target - gap] == 1){
                return gap;
            } else if(target + gap <= dpLen && dp[target + gap] == 1){
                return gap;
            } else {
                gap += 1;
            }
        }
    }

}
