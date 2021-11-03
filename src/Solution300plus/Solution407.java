package Solution300plus;

import java.util.PriorityQueue;

public class Solution407 {
    public int trapRainWater(int [][]heightMap){
        if(heightMap.length<=2||heightMap[0].length<=2){
            return 0;
        }
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean [][]visit=new boolean[m][n];
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==m-1||j==0||j==n-1){
                    p.add(new int[]{i*n+j,heightMap[i][j]});
                    visit[i][j]=true;
                }
            }
        }
        int res=0;
        int[] dir={-1,0,1,0,-1};
        while(!p.isEmpty()){
            int []curr =p.poll();
            for(int k=0;k<4;k++){
                int x=curr[0]/n+dir[k];
                int y=curr[0]%n+dir[k+1];
                if(x>0&&x<m&&y>=0&&y<n&&!visit[x][y]){
                    if(curr[1]>heightMap[x][y]){
                        res+=curr[1]-heightMap[x][y];
                    }
                    p.add(new int[]{x*n+y,Math.max(heightMap[x][y],curr[1])});
                    visit[x][y]=true;
                }
            }
        }
        return res;
    }
}
