import java.util.*;

public class Zhou1010 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> ans=new HashSet<>();
        for(int i:nums1){
            for(int j:nums2){
                if(i==j){
                    ans.add(i);
                }
            }
            for(int j:nums3){
                if(i==j){
                    ans.add(i);
                }
            }
        }
        for(int i:nums2) {
            for (int j : nums3) {
                if (i == j) {
                    ans.add(i);
                }
            }
        }
        List<Integer> ans0=new ArrayList<>(ans);
        return ans0;
    }
    public int minOperations(int[][] grid, int num) {
        int n=grid.length*grid[0].length;
        int a[]=new int[n];
        int index=0;
        for(int x[]:grid){
            for(int y:x){
                a[index]=y;
                index++;
                if(Math.abs(y-grid[0][0])%num!=0){
                    return -1;
                }
            }
        }
        Arrays.sort(a);
        int ans=0;
        for(int i:a){
            ans+=Math.abs(i-a[n/2])/num;
        }
        return ans;
    }
}
