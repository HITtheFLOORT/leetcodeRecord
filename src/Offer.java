import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;//if...else...
        return n;
    }
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<List<Integer>> Res=new LinkedList<>();
        LinkedList<Integer> tmp=new LinkedList<>();
        recur(root,target,Res,tmp);
        return Res;
    }
    public void recur(TreeNode root, int target,LinkedList<List<Integer>> res,LinkedList<Integer> tmp){
        if(root==null){
            return;
        }
        tmp.add(root.val);
        target-=root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(tmp));
        recur(root.left, target,res,tmp);
        recur(root.right, target,res,tmp);
        tmp.removeLast();
    }

}
