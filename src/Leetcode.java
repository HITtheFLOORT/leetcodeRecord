import java.util.Scanner;

public class Leetcode {
    public static boolean isgray(int a[][],int x,int y,int r,int limit){
        int sum=0;
        for(int i=x;i<=x+2*r;i++){
            for(int j=y;j<=y+2*y;j++){
                sum+=a[i][j];
            }
        }
        if(sum/((2*r+1)*(2*r+1))<limit){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
      Scanner in =new Scanner(System.in);
      int n=in.nextInt();
      int max=in.nextInt();
      int r=in.nextInt();
      int limit=in.nextInt();
      int ans=0;
      int a[][]=new int[n][n];
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              a[i][j]=in.nextInt();
          }
        }
      for(int i=0;i<n-2*r;i++){
          for(int j=0;j<n-2*r;j++){
                if(isgray(a,i,j,r,limit)){
                    ans++;
                }
          }
      }
      System.out.println(ans);
    }
}
