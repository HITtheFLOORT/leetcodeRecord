import java.util.*;

public class Matric {
    public  void rotate(int matrix[][]){
        /*
        给定一个 n × n 的二维矩阵表示一个图像。

        将图像顺时针旋转 90 度。
         */
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        int times = 0;
        while(times <= (nums >> 1)){
            int len = nums - (times << 1);
            for(int i = 0; i < len - 1; ++i){
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int h=heightMap.length;
        int l=heightMap[0].length;
        int vis[][]=new int[h][l];
        for(int i=1;i<h-1;i++){
            for(int j=1;j<l-1;j++){
                vis[i][j]=1;
            }
        }
        for(int i=1;i<h-1;i++){
            for(int j=1;j<l-1;j++){
                if(vis[i][j]>0){
                    //??????
                }
            }
        }
        return 0;
    }
    public List<String> summaryRanges(int[] nums) {
        /*
        给定一个无重复元素的有序整数数组 nums 。

        返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

        输入：nums = [0,2,3,4,6,8,9]
        输出：["0","2->4","6","8->9"]
        解释：区间范围是：
        [0,0] --> "0"
        [2,4] --> "2->4"
        [6,6] --> "6"
        [8,9] --> "8->9"
         */
        List ls=new ArrayList();
        int head=0;
        int tail=0;
        if(nums.length!=0){
            head=nums[0];
            tail=nums[0];
        }
        else{
            return ls;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1>nums[i-1]){
                //System.out.println(head+" "+tail);
                if(head!=tail){
                    ls.add(head+"->"+tail);
                }else{
                    ls.add(head+"");
                }
                head=nums[i];
                tail=nums[i];

            }else{
                tail=nums[i];
            }
        }
        if(head!=tail){
            ls.add(head+"->"+tail);
        }else{
            ls.add(head+"");
        }
        return ls;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
      int a=matrix.length*matrix[0].length;
      ArrayList ll=new ArrayList();
      int m[][]=new int[matrix.length][matrix[0].length];
      int x=0,y=0;
      int action=1;//1234
      for(int i=0;i<a;i++){
        switch (action){
            case 1:{
                if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                    ll.add(matrix[x][y]);
                    m[x][y]=1;
                    if(a==ll.size()){
                        break;
                    }
                    y++;
                }else{
                    action=2;
                    y--;
                    x++;
                    i--;
                }
                break;
            }
            case 2:{
                if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                    ll.add(matrix[x][y]);
                    m[x][y]=1;
                    if(a==ll.size()){
                        break;
                    }
                    x++;
                }else{
                    action=3;
                    x--;
                    y--;
                    i--;
                }
                break;
            }
            case 3:{
                if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                    ll.add(matrix[x][y]);
                    m[x][y]=1;
                    if(a==ll.size()){
                        break;
                    }
                    y--;
                }else{
                    action=4;
                    y++;
                    x--;
                    i--;
                }
                break;
            }
            case 4:{
                if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                    ll.add(matrix[x][y]);
                    m[x][y]=1;
                    if(a==ll.size()){
                        break;
                    }
                    x--;
                }else{
                    action=1;
                    x++;
                    y++;
                    i--;
                }
                break;
            }


        }
      }

      return ll;
    }

    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int m[][]=new int[n][n];
        int action=1;
        int x=0,y=0;
        int step=0;
        for(int i=1;i<=n*n;i++){
            switch (action){
                case 1:{
                    if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                        matrix[x][y]=i;
                        m[x][y]=1;
                        step++;
                        if(step==n*n){
                            break;
                        }
                        y++;
                    }else{
                        action=2;
                        y--;
                        x++;
                        i--;
                    }
                    break;
                }
                case 2:{
                    if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                        matrix[x][y]=i;
                        m[x][y]=1;
                        step++;
                        if(step==n*n){
                            break;
                        }
                        x++;
                    }else{
                        action=3;
                        x--;
                        y--;
                        i--;
                    }
                    break;
                }
                case 3:{
                    if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                        matrix[x][y]=i;
                        m[x][y]=1;
                        step++;
                        if(step==n*n){
                            break;
                        }
                        y--;
                    }else{
                        action=4;
                        y++;
                        x--;
                        i--;
                    }
                    break;
                }
                case 4:{
                    if(x>=0&&y>=0&&y<matrix[0].length&&x<matrix.length&&m[x][y]==0){
                        matrix[x][y]=i;
                        m[x][y]=1;
                        step++;
                        if(step==n*n){
                            break;
                        }
                        x--;
                    }else{
                        action=1;
                        x++;
                        y++;
                        i--;
                    }
                    break;
                }
            }
        }
        return matrix;
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = (high-low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if(x < target){
                low = mid + 1;
            }else if(x > target){
                high = mid - 1;
            }else {
                return true;
            }

        }
        return false;
    }
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return new int[0];
        }else{
            q.add(root);
        }
        ArrayList<Integer> a=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            a.add(t.val);
            if(t.left!=null){q.add(t.left);}
            if(t.right!=null){q.add(t.right);}
        }
        int result[]=new int[a.size()];
        for(int i=0;i<result.length;i++){
            result[i]=a.get(i);
        }
        return result;
    }
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int pointr[]=new int[height.length];
        int pointl[]=new int[height.length];
        int res=0;
        pointl[0]=height[0];
        for(int i=1;i<height.length;i++){
            pointl[i]=Math.max(height[i],pointl[i-1]);
        }
        pointr[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            pointr[i]=Math.max(height[i],pointr[i+1]);
        }
        for(int i=0;i<height.length;i++){
            res+=Math.min(pointl[i],pointr[i])-height[i];
        }
        return res;
    }
    int pre;
    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(pre==-1){
            pre=root.val;
        }else{
            ans=Math.min(ans, root.val-pre);
            pre= root.val;
        }
        dfs(root.right);
    }
}
class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }
