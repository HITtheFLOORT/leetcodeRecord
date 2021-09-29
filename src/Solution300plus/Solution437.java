package Solution300plus;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> prefix=new HashMap<>();
        prefix.put(0l,1);
        return dfs(root,prefix,0,targetSum);
    }
    public int dfs(TreeNode root, Map<Long,Integer> prefix, long curr, int targetnum){
        if(root==null){
            return 0;
        }
        int ret=0;
        curr+= root.val;
        ret+=prefix.getOrDefault(curr-targetnum,0);
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        ret+=dfs(root.left,prefix,curr,targetnum);
        ret+=dfs(root.right,prefix,curr,targetnum);
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);
        return ret;
    }
}
