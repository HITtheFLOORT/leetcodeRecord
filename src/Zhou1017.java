import java.util.HashMap;
import java.util.Map;

public class Zhou1017 {
    public boolean areNumbersAscending(String s) {
        String res[]=s.split(" ");
        int tmp=0;
        for(int i=0;i<res.length;i++){
            if(res[i].length()>0&&Character.isDigit(res[i].charAt(0))){
                if(Integer.parseInt(res[i])>tmp){
                    tmp=Integer.parseInt(res[i]);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    private int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        // 按位或是不减的操作，所以全部 | 起来是最大值
        int sum = 0;
        for(int p : nums){
            sum |= p;
        }
        dfs(nums, sum, 0, 0);
        return ans;
    }
    public void dfs(int[] nums, int sum, int idx, int cur) {
        // 剪枝
        if (cur == sum) {
            ans += 1 << (nums.length - idx);
            return;
        }
        if (idx == nums.length) {
            return;
        }
        // 加上这个数
        dfs(nums, sum, idx + 1, cur | nums[idx]);
        // 不加这个数
        dfs(nums, sum, idx + 1, cur);

    }
    public int countMaxOrSubsets2(int[] nums) {
        int N = 1 << nums.length;
        int dp[]=new int[N];
        // 初始状态
        for (int i = 0; i < nums.length; ++i) {
            dp[1 << i] = nums[i];
        }
        for (int i = 1; i < N; ++i) {
            int lowBit = i & (-i);
            if ((i ^ lowBit) == 0) continue;
            // 状态转移
            dp[i] = dp[i ^ lowBit] | dp[lowBit];
        }
        int ans = 0;
        for (int i = 1; i < N; ++i) {
            if (dp[i] == dp[N - 1]) ans++;
        }
        return ans;
    }
}
class Bank {
    Map<Integer,Long> allcounts=new HashMap<>();
    public Bank(long[] balance) {
        for(int i=0;i<balance.length;i++){
            allcounts.put(i+1,balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if(!allcounts.containsKey(account2)) {
            return false;
        }
        if(!withdraw(account1,money)){
            return false;
        }
        long own=allcounts.get(account2);
        allcounts.put(account2,own+money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if(!allcounts.containsKey(account)){
            return false;
        }
        long own=allcounts.get(account);
        allcounts.put(account,own+money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(!allcounts.containsKey(account)){
            return false;
        }
        long own=allcounts.get(account);
        if(own-money<0){
            return false;
        }else{
            allcounts.put(account,own-money);
        }
        return true;
    }
}