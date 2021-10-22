package Solution201to300;

import java.util.ArrayList;
import java.util.List;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int vote1=0,vote2=0;
        int count1=0,count2=0;
        for(int num:nums){
            if(vote1==0){
                count1=num;
                vote1++;
            }else if(vote2==0){
                count2=num;
                vote2++;
            }else if(vote1>0&&num==count1){
                vote1++;
            }else if(vote2>0&&num==count2){
                vote2++;
            }else{
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == count1) {
                cnt1++;
            }
            if (vote2 > 0 && num == count2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(count1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(count2);
        }


        return ans;
    }
}
