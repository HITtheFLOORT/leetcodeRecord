package Solution1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        //a
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //c
            int k=n-1;
            int target=-nums[i];
            //b
            for(int j=i+1;j<n;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while(j<k&&nums[j]+nums[k]>target){
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                }
                if(j==k){
                    break;
                }
                if(nums[j]+nums[k]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }

        }
        return ans;
    }
}
