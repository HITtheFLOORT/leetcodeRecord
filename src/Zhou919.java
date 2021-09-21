import java.util.HashMap;
import java.util.Map;

public class Zhou919 {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String s:operations){
            switch (s){
                case "++X" : ans++;break;
                case "X++" : ans++;break;
                case "--X" : ans--;break;
                case "X--" : ans--;break;
            }
        }
        return ans;
    }
    public int sumOfBeauties(int[] nums) {
        int maxval[][]=new int[nums.length][2];
        maxval[nums.length-1][1]=nums[nums.length-1];
        maxval[0][0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int j=nums.length-1-i;
            maxval[i][0]=Math.max(nums[i],maxval[i-1][0]);
            maxval[j][1]=Math.min(nums[j],maxval[j+1][1]);
        }
        int ans=0;
        for(int i=1;i<nums.length-1;i++){
            if(maxval[i-1][0]<nums[i]&&nums[i]<maxval[i+1][1]){
                ans++;
            }else
            if(nums[i-1]<nums[i]&&nums[i]<nums[i+1]){
                ans++;
            }

        }
        return ans;
    }
}
class DetectSquares {
    Map<String, Integer> map = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        // 只找下方对角线的点
        int res = 0;
        int x = point[0];
        int y = point[1];
        for (String key : map.keySet()) {
            int delX = Integer.parseInt(key.split(",")[0]);
            int delY = Integer.parseInt(key.split(",")[1]);
            int delCnt = map.get(key);
            if (delX != x && delY != y && Math.abs(delX - x) == Math.abs(delY - y) && delCnt > 0) {
                // 计算平行X的点(delX, y)和平行Y的点(x, delY)个数
                int xParCnt = map.getOrDefault(delX + "," + y, 0);
                int yParCnt = map.getOrDefault(x + "," + delY, 0);
                res += delCnt * xParCnt * yParCnt;
            }
        }
        return res;
    }
}
