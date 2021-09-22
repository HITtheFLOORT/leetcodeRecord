package Solution201to300;

public class Solution275 {
    public int hIndex(int[] citations) {
        int l=0;
        int n=citations.length;
        int r=citations.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(citations[mid]>=n-mid){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return n-l;
    }
}
