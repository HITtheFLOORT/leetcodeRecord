package Solution201to300;

public class Solution230 {
    int res=0;
    boolean flag=true;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode node,int target){
        if(!flag||node==null){
            return;
        }
        dfs(node.left,target);
        target--;
        if(flag&&target==0){
            res=node.val;
            flag=false;
        }
        dfs(node.right,target);
    }
}
