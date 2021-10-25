package Solution201to300;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int r=n-1,l=0;
        for(int i=0;i<m;i++){
            while(l<=r){
                int mid=(l+r)/2;
                if(matrix[i][mid]>target){
                    r=mid-1;
                }else if(matrix[i][mid]<target){
                    l=mid+1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
