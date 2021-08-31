public class Pickindex {
    int  sum[];
    int total;
    public Pickindex(int[] w) {
        sum=new int[w.length];
        sum[0]=w[0];
        for(int i=1;i<w.length;i++){
            sum[i]=sum[i-1]+w[i];
        }
        total=sum[w.length-1];
    }

    public int pickIndex() {
       int x=(int)(Math.random()*total)+1;
       return binarySearch(x);
    }
    public int binarySearch(int x){
        int low=0,high=sum.length-1;
        while(low<high){
            int mid =(low+high)/2;
            if(sum[mid]<x){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}
