import java.util.*;

public class EasyProblem {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++ ){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,1};
    }
    public  void binary(){
        //二进制转换，反转
        String s=Integer.toBinaryString(12);
        StringBuffer sb=new StringBuffer(s);
        sb=sb.reverse();
        int i=Integer.valueOf(sb.toString(),2);
        System.out.println(s);
        System.out.println(sb);
        System.out.println(i);
    }
    public int reverse(int x) {

        boolean flag=true;
        if(x<0){
            x=0-x;
           flag=false;
        }
        String s=Integer.toString(x);
        StringBuffer sb=new StringBuffer(s);
        sb.reverse();
        try {
            if(flag){
                return Integer.valueOf(sb.toString());
            }
            else{
                return 0-Integer.valueOf(sb.toString());
            }
        }catch (Exception e){
           return 0;
        }
    }
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode ReverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
        return pre;
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> de=new LinkedList();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            de.push(pushed[i]);
            while(!de.isEmpty()&&de.peek()==popped[j]){
                de.pop();
                j++;
            }
        }
        if(de.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[slow]){
                slow++;
                nums[slow]=nums[i];
            }
        }
        return slow+1;
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        "ad".indexOf("a");
        int slow=0;
        for(int i=0;i<nums.length;i++){
            if(val!=nums[i]){
                nums[slow]=nums[i];
                slow++;
            }
        }
        return slow;
    }
//    public TreeNode increasingBST(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        inorder(root, res);
//
//        TreeNode dummyNode = new TreeNode(-1);
//        TreeNode currNode = dummyNode;
//        for (int value : res) {
//            currNode.right = new TreeNode(value);
//            currNode = currNode.right;
//        }
//        return dummyNode.right;
//    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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
    public int getImportance(List<Employee> employees, int id) {
        Deque<Employee> que=new LinkedList<>();
        que.add(getINDEX(employees,id));
        int res=0;
        while(!que.isEmpty()){
            Employee e=que.pollFirst();
            res+=e.importance;
            List<Integer> ls=e.subordinates;
            for(int i=0;i<ls.size();i++){
                que.add(getINDEX(employees,e.subordinates.get(i)));
            }
        }
        return res;
    }
    public Employee getINDEX(List<Employee> employees, int id){
        for(int i=0;i<employees.size();i++){
            if(id==employees.get(i).id){
                return employees.get(i);
            }
        }
        return new Employee();
    }
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
    public int[] decode(int[] encoded, int first) {
        int arr[]=new int[encoded.length+1];
        arr[0]=first;
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]^encoded[i-1];
        }
        return arr;
    }
    public int xorOperation(int n, int start) {
        int res=start;
        for(int i=1;i<n;i++){
            res^=(start+i*2);
        }
        return res;
    }
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        update(root, null, 0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
                update(node.left, node, depth + 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                update(node.right, node, depth + 1);
            }
            if (xFound && yFound) {
                break;
            }
        }

        return xDepth == yDepth && xParent != yParent;
    }

    // 用来判断是否遍历到 x 或 y 的辅助函数
    public void update(TreeNode node, TreeNode parent, int depth) {
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
    }
    public int hammingDistance(int x, int y) {
        int resnum=x^y,res=0;
        while(resnum>0){
            res+=resnum&1;
            resnum>>=1;
        }
        return Integer.bitCount(resnum);
    }
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;//mask=(10101010101010101010101010101010)

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one=headA;
        ListNode two=headB;
        if(one==null||two==null){
            return null;
        }
        while(one!=two){
            one=one.next;
            two=two.next;
            if(one==null&&two!=null){
                one=headA;
            }
            if(two==null&&one!=null){
                two=headB;
            }
        }
        return one;
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid-1]<arr[mid]&&arr[mid]<arr[mid+1]){
                l=mid;
            }
            if(arr[mid-1]>arr[mid]&&arr[mid]>arr[mid+1]){
                r=mid;
            }
            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1]){
                r=mid;
                break;
            }
        }
        return r;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
    public int numWays(int n, int[][] relation, int k) {
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 0; i < k; i++) {
                int[] next = new int[n];
                for (int[] edge : relation) {
                    int src = edge[0], dst = edge[1];
                    next[dst] += dp[src];
                }
                dp = next;
            }
            return dp[n - 1];
    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n/2;i++){
            max=Math.max(max,nums[i]+nums[n-1-i]);
        }
        return max;
    }
    boolean isdfs=false;
    public boolean exist(char[][] board, String word) {
        int x[][]=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]&&!isdfs){
                    dfs(word,board,x,1,i,j);
                }
            }
        }
        return isdfs;
    }
    public void dfs(String s,char[][] a,int[][] o,int step,int i,int j){
        if(step==s.length()&&!isdfs){
            isdfs=true;
        }else{
            if(i+1<a.length&&o[i+1][j]!=1&&a[i+1][j]==s.charAt(step)){
                o[i+1][j]=1;
                dfs(s,a,o,step+1,i+1,j);
                o[i+1][j]=0;
            }
            if(i-1>=0&&o[i-1][j]!=1&&a[i-1][j]==s.charAt(step)){
                o[i-1][j]=1;
                dfs(s,a,o,step+1,i-1,j);
                o[i-1][j]=0;
            }
            if(j+1<a[0].length&&o[i][j+1]!=1&&a[i][j+1]==s.charAt(step)){
                o[i][j+1]=1;
                dfs(s,a,o,step+1,i,j+1);
                o[i][j+1]=0;
            }
            if(j-1>=0&&o[i][j-1]!=1&&a[i][j-1]==s.charAt(step)){
                o[i][j-1]=1;
                dfs(s,a,o,step+1,i,j-1);
                o[i][j-1]=0;
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null){
            return -1;
        }
        int ro= root.val;
        int min2=Integer.MAX_VALUE;
        Deque<TreeNode> de=new LinkedList<>();
        de.push(root);
        while(!de.isEmpty()){
            TreeNode tmp=de.pop();
            if(tmp.right!=null){
                if(tmp.right.val==ro){
                    de.push(tmp.right);
                    min2=ro==tmp.left.val?min2:Math.min(min2,tmp.left.val);
                }
                if(tmp.left.val==ro){
                    de.push(tmp.left);
                    min2=ro==tmp.right.val?min2:Math.min(min2,tmp.right.val);
                }
            }

        }
        if(min2==Integer.MAX_VALUE){
            return -1;
        }else{
            return min2;
        }

    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }

        return Arrays.stream(nums).distinct().count() < nums.length;
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int sum[]=new int [n];
        sum[0]=arr[0];
        int ans=0;
        for(int i=1;i<n;i++){
            sum[i]=arr[i]+sum[i-1];
        }
        int len=1;
        while(len<=n){
            for(int i=0;i+len-1<n;i++){
                if(i==0){
                    ans+=sum[i+len-1];
                }else{
                    ans+=sum[i+len-1]-sum[i-1];
                }
            }
            len+=2;
        }
        return ans;
    }

}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
