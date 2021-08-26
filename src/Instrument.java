public class Instrument {//704
    public int search(int[] nums, int target) {
        int l=0;
        int n=nums.length;
        int r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public boolean isBadVersion(int x){
        return false;
    }
    public int firstBadVersion(int n) {//278
        int l=1;
        int r=n;
        while(l<r){
            int mid=l+(r-l)/2;//区间长度，防止r+l溢出
            if(isBadVersion(mid)){
               r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public int searchInsert(int[] nums, int target) {//35
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
