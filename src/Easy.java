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

}
