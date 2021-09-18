import java.math.BigInteger;
import java.util.Arrays;

public class Easy {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[]=new int[nums1.length];
        int i=0,j=0,k=0;
        while(k<res.length){
            if(i<m&&j<n&&nums1[i]<nums2[j]){
                res[k]=nums1[i];
                i++;
            }else if(i<m&&j<n&&nums1[i]>=nums2[j]){
                res[k]=nums2[j];
                j++;
            }else if(i==m){
                res[k]=nums2[j];
                j++;
            }else if(j==n){
                res[k]=nums1[i];
                i++;
            }
            k++;
        }

        for(i=0;i<res.length;i++){
            nums1[i]=res[i];
        }
    }
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int a[]=new int[n+1];
        a[1]=1;
        for(int i=1;i<n+1;i++){
            if(a[i]==0){
                continue;
            }
            if(i*2<n+1){
                a[i*2]=1;
            }
            if(i*3<n+1){
                a[i*3]=1;
            }
            if(i*5<n+1){
                a[i*5]=1;
            }
        }
        return a[n]==1;
    }
    public int nthUglyNumber(int n) {
        int a[]=new int[n+1];
        a[1]=1;
        int p2=1,p3=1,p5=1;
        for(int i=2;i<n+1;i++){
            a[i]=Math.min(Math.min(a[p2]*2,a[p3]*3),a[p5]*5);
            if(a[i]==a[p2]*2){
                p2++;
            }
            if(a[i]==a[p3]*3){
                p3++;
            }
            if(a[i]==a[p5]*5){
                p5++;
            }
        }
        return a[n];
    }
    public boolean zhi(int a){
        int x=2;
        while(x<=(a/2)){
            if(a%x==0){
                return false;
            }
            x++;
        }
        return true;
    }
    public int titleToNumber(String columnTitle) {
        int ans=0;
        for(int i=0;i<columnTitle.length();i++){
            ans*=26;
            ans+=columnTitle.charAt(i)-'A'+1;
        }
        return ans;
    }
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public int minimumDifference(int[] nums, int k) {
        if(nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=0;i+k-1<nums.length;i++){
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;
    }
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
    public int translateNum(int num) {
        char s[]=(num+"").toCharArray();
        if(s.length<2){
            return s.length;
        }
        int p = 0, q = 1, r = ispreillegal(s,0)?2:1;
        for (int i = 2; i < s.length; ++i) {
            p = q;
            q = r;
            r = ispreillegal(s,i-1)?(p + q):q;
        }
        return r;
    }
    private boolean ispreillegal(char num[],int i){
        int a=(num[i]-'0')*10+(num[i+1]-'0');
        if(a<=25&&a>=10){
            return true;
        }else{
            return false;
        }
    }
    public int balancedStringSplit(String s) {
        int r=0,l=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                r++;
            }
            if(s.charAt(i)=='L'){
                l++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
