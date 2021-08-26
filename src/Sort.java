public class Sort {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while(right>=left){
            int mid=(left+right)/2;
            int midnum=nums[mid];
            if(midnum==target){
                return mid;
            }
            if(nums[mid]<nums[right]){
                if(midnum<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(nums[left]<=target&&target<midnum){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
    public boolean search2(int[] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            int midnum=nums[mid];
            if(midnum==target){
                return true;
            }
            if(midnum==nums[right]&&nums[left]==midnum){
                left++;
                right--;
            }else{
                if(midnum<=nums[right]){
                    if(midnum<target&&target<=nums[right]){
                        left=mid+1;
                    } else{
                        right=mid-1;
                    }
                }else{
                    if(nums[left]<=target&&target<midnum){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
            }
        }
        return false;
    }
}
