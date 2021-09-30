package Solution201to300;

import java.util.*;

//拓扑序列207 210
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        PriorityQueue pq=new PriorityQueue();
        List<Integer> edges[]=new List[numCourses];
        int []indeg=new int[numCourses];
        for(int i=0;i<edges.length;i++){//初始化
            edges[i]=new ArrayList<>();
        }
        for(int info[]:prerequisites){//创建图
            edges[info[1]].add(info[0]);//info[1]->info[0]
            ++indeg[info[0]];           //记录入边
        }
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                qu.offer(i);
            }
        }
        int visited=0;
        while(!qu.isEmpty()){
            ++visited;
            int u=qu.poll();
            for(int v:edges[u]){
                --indeg[v];
                if(indeg[v]==0){
                    qu.offer(v);
                }
            }
            if(visited>numCourses){
                return false;
            }
        }
        return visited==numCourses;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> edges[]=new List[numCourses];
        int []indeg=new int[numCourses];
        for(int i=0;i<edges.length;i++){
            edges[i]=new ArrayList<>();
        }
        for(int info[]:prerequisites){
            edges[info[1]].add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                qu.offer(i);
            }
        }
        int visited=0;
        int ans[]=new int[numCourses];
        while(!qu.isEmpty()){
            int u=qu.poll();
            ans[visited]=u;
            ++visited;
            for(int v:edges[u]){
                --indeg[v];
                if(indeg[v]==0){
                    qu.offer(v);
                }
            }
            if(visited>numCourses){
                break;
            }
        }
        return visited==numCourses?ans:new int[0];
    }
}
