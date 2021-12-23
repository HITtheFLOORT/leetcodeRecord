import java.util.*;

public class Zhou1121 {
    public int maxDistance(int[] colors) {
        int ans=0;
        for(int i=0;i<colors.length;i++){
            for(int j=i+1;j< colors.length;j++){
                if(colors[i]!= colors[j]){
                  ans=Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }
    public int wateringPlants(int[] plants, int capacity) {
        int bucket=capacity;
        int count =0;
        for(int i=0;i<plants.length;i++){
            if(bucket>=plants[i]){
                count++;
            }else{
                count+=i;
                bucket=capacity;
                count+=i+1;
            }
            bucket-=plants[i];
        }
        return count;
    }
    class RangeFreqQuery {
        Map<Integer, ArrayList<Integer>> ma=new HashMap<>();
        public RangeFreqQuery(int[] arr) {
            for(int i=0;i<arr.length;i++){
                ArrayList<Integer> tmp=new ArrayList<>();
                if(ma.containsKey(arr[i])){
                    tmp=ma.get(arr[i]);
                }
                tmp.add(i);
                ma.put(arr[i],tmp);
            }
        }

        public int query(int left, int right, int value) {
            if(ma.containsKey(value)){
                ArrayList<Integer> tmp=ma.get(value);
                int l=0,r=tmp.size()-1;
                int a=binarySearch(tmp,l,r,left);
                if(tmp.get(a)>right||tmp.get(a)<left){
                return 0;
                }
                int b=binarySearch(tmp,l,r,right);
                if(tmp.get(b)>right){
                    b--;
                }
                return b-a+1;
            }else{
                return 0;
            }
        }
        public int binarySearch(List<Integer> nums, int l , int r, int target) {
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (nums.get(mid) < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
