import java.util.*;

public class MediaProblem {
    public int equalSubstring(String s, String t, int maxCost) {
        int a[]=new int[s.length()];
        for(int i=0;i<a.length;i++){
            a[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int maxstep=0;
        for(int i=0;i<a.length;i++){
            int cost=a[i];
            int step=0;
            int j=i+1;
            if(cost<=maxCost){
                step=1;
                maxstep=step>maxstep?step:maxstep;
                while(j<a.length&&cost+a[j]<=maxCost){
                    cost+=a[j];
                    j++;
                    step++;
                    maxstep=step>maxstep?step:maxstep;
                }
            }
        }
        return maxstep;
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int fast=2;
        int slow=2;
        for(int i=fast;i<nums.length;i++){
            if(nums[slow-2]!=nums[i]){
                nums[slow]=nums[i];
                slow++;
            }
        }
        return slow;
    }
    public int numRabbits(int[] answers) {
        if(answers.length==0){
            return 0;
        }
        int a[]=new int[1000];
        for(int i=0;i<answers.length;i++){
            a[answers[i]]++;
        }
        int ans=0;
        for(int i=1;i<a.length;i++){
            if(a[i]!=0){
                ans+=(i+1)*(a[i]/(i+1));
                if(a[i]%(i+1)!=0){
                    ans+=(i+1);
                }
            }
        }
        return ans+a[0];
    }
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.min(nums[0],nums[1]);
        }
        int left=0;
        int right=nums.length-1;
        while(left+1<right){
            int mid=(left+right)/2;
            int midum=nums[mid];
            if(midum<nums[right]){
                right=mid;
            }else if(nums[left]<midum){
                left=mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<=n-2;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        int dp2[]=new int[n];
        dp2[0]=nums[1];
        dp2[1]=Math.max(dp2[0],nums[2]);
        for(int i=2;i<=n-2;i++){
            dp2[i]=Math.max(nums[i+1]+dp2[i-2],dp2[i-1]);
        }
        return Math.max(dp[n-2],dp2[n-2]);
    }
    public int nthUglyNumber(int n) {
        int dp[]=new int[n+1];
        dp[1]=1;
        int two=1;
        int three=1;
        int five=1;
        for(int i=2;i<n+1;i++){
            dp[i]=Math.min(Math.min(dp[two]*2,dp[three]*3),dp[five]*5);
            if(dp[i]==dp[two]*2){
                two++;
            }
            if(dp[i]==dp[three]*3){
                three++;
            }
            if(dp[i]==dp[five]*5){
                five++;
            }
        }
        return dp[n];
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        Map<Long,Long> map=new HashMap<>();
        long w=(long)t+1;
        for(int i=0;i<n;i++){
            long id=getID(nums[i],w);
            if(map.containsKey(id)){
                return true;
            }
            if(map.containsKey(id-1)&&Math.abs(map.get(id-1)-nums[i])<w){
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id,(long)nums[i]);
            if(i>=k){
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }
    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null){
            qu.add(root);
        }
        while(!qu.isEmpty()){
            LinkedList<Integer> tmp=new LinkedList<>();
            for(int i=qu.size();i>0;i--){
                TreeNode no=qu.poll();
                if(res.size()%2==0){
                    tmp.addLast(no.val);
                }else{
                    tmp.addFirst(no.val);
                }
                if(no.left!=null){
                    qu.add(no.left);
                }
                if(no.right!=null){
                    qu.add(no.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> cmp;
        cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            } };
// 建立最大堆
        Queue<Integer> q = new PriorityQueue<Integer>(cmp); for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]); }
        for(int i=0;i<k-1;i++){ q.poll();
        }
        return q.poll();
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob2(sum);
    }

    public int rob2(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
    public String longestPalindrome(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        int maxlen=1;
        int begin=0;
        for(int len=2;len<=s.length();len++){
            for(int i=0;i<s.length();i++){
                int j=i+len-1;
                if(j>=s.length()){
                    break;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(len<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if(dp[i][j]&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    public int myAtoi(String str) {
        int len = str.length();

        char[] charArray = str.toCharArray();
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
    List<List<Integer>> res=new LinkedList();
    public List<List<Integer>> threeSum(int[] nums) {
        quansort(nums,0,0);
        return res;
    }
    public boolean check(int nums[]){
        if(nums[0]+nums[1]+nums[2]==0){
            List<Integer> a=new ArrayList<>();
            a.add(nums[0]);
            a.add(nums[1]);
            a.add(nums[2]);
            res.add(a);
            return true;
        }else{
            return false;
        }
    }
    public void quansort(int[] nums,int x,int step){
        if(step==3){
            check(nums);
            return;
        }
        for(int i=x;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                quansort(nums,i,step+1);
            }
        }
    }
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int x=0;
        for(int k=HIGH_BIT;k>=0;k--){
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num>>k);
            }
            int wei=x*2+1;
            boolean found=false;
            for(int num:nums){
                if(set.contains(wei^(num>>k))){
                    found=true;
                    break;
                }
            }
            if (found) {
                x = wei;
            } else {
                x = wei - 1;
            }

        }
        return x;
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec,(word1,word2)->{
            return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1); });
        return rec.subList(0, k);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long sum[]=new long[candiesCount.length];
        sum[0]=candiesCount[0];
        for(int i=1;i<sum.length;i++){
            sum[i]=candiesCount[i]+sum[i-1];
        }
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int qu[]=queries[i];
            long x1=qu[1]+1;
            long y1=(long)(qu[1]+1)*qu[2];
            long x2=qu[0] == 0 ? 1 : sum[qu[0] - 1] + 1;
            long y2=sum[qu[0]];
            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
    public int findMaxLength(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int max=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        int count=0;
        hs.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int k=nums[i]==1?1:-1;
            count=count+k;
            if(hs.containsKey(count)){
                    int x=hs.get(count);
                    max=Math.max(max,i-x);
            }else{
                hs.put(count,i);
            }
        }
        return max;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hs= new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            int num[]=new int[26];
            Arrays.fill(num,0);
            for(int j=0;j<strs[i].length();j++){
                num[strs[i].charAt(j)-'a']++;
            }
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<26;j++){
                if(num[j]!=0){
                    sb.append((char)('a'+j));
                    sb.append(num[j]);
                }
            }
            if(hs.containsKey(sb.toString())){
                hs.get(sb.toString()).add(strs[i]);
            }else{
                List<String> ls=new ArrayList<>();
                ls.add(strs[i]);
                hs.put(sb.toString(),ls);
            }
        }
        List<List<String>> res=new ArrayList<>(hs.values());
        return res;
    }
    public int jump(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
    public int jump2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int boundary=0;
        int min=0;
        int times=0;
        for(int i=0;i<nums.length;i++){
            boundary=Math.max(boundary,nums[i]+i);
            if (boundary>=nums.length-1){
                times++;
                break;
            }
            if(i==min){
                times+=1;
                min=boundary;
            }
        }
        return times;
    }
    public String multiply(String num1, String num2) {
        int res=0;
        for(int i=0;i<num1.length();i++){

             int wei=0;
            for(int j=0;j<num2.length();j++){
                wei=10*wei+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
            res=res*10+wei;
        }
       return res+"";
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if((sum-target)<0||(sum-target)%2!=0){
            return 0;
        }
        int n=nums.length,neg=(sum-target)/2;
        int dp[]=new int[neg+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=neg;j>=nums[i];j--){
                    dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[neg];
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][]=new int[n+1][minProfit+1];
            for(int i=0;i<=n;i++){
                dp[i][0]=1;
            }
            int len=group.length, mod=(int)1e9+7;
            for(int i=1;i<=len;i++){
                for(int j=n;j>=group[i-1];j--){
                    for(int k=minProfit;k>=0;k--){
                        dp[j][k]=dp[j][k]+dp[j-group[i-1]][Math.max(0,k-profit[i-1])]%mod;
                    }
                }
            }
            return dp[n][minProfit];
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode nonius=head;
        ListNode be_nonius=head;
        ListNode pre=head;
        int len=0;
        while(nonius!=null){
            if(len<n){
                nonius=nonius.next;
                len++;
            }else{
                pre=be_nonius;
                nonius=nonius.next;
                be_nonius=be_nonius.next;
            }
        }
        if(len==n){
            if(pre==head){
                head=head.next;
            }else{
                pre.next=be_nonius.next;
            }

        }
        return head;
    }
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                List<Integer> ls=new ArrayList<>();
                ls.add(i);
                ls.add(j);
                res.add(ls);
            }
        }
        return res;
    }
    public int change(int amount, int[] coins) {
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=1;i<=coins.length;i++){
            for(int j=amount;j>=coins[i-1];j--){
                dp[j]=dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[amount];
    }
    public boolean canJump(int[] nums) {
        int bd=0;
        for(int i=0;i<nums.length;i++){
            if(i<bd){
                bd=Math.max(bd,i+nums[i]);
                if(bd>=nums.length-1){
                    return true;
                }
            }else{
                break;
            }
        }
        return false;
    }
    public boolean PredictTheWinner(int[] nums) {//[1,5,2]
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return  dp[0][n-1]>=0;
    }
    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        //s=s.toLowerCase();
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
         int size=0;
         ListNode record=head;
         ListNode tail=head;
         while(record!=null){
             size++;
             if(record.next==null){
                tail=record;
             }
             record=record.next;
         }
         k=size-k%size;
         int target=0;
         record=head;
         while(record!=null){
            target++;
             if(target==k){
                 break;
             }
            record=record.next;
         }
         tail.next=head;
         head=record.next;
         record.next=null;
         return head;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                dp[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                dp[0][i]=1;
            }else{
                break;
            }

        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){

                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        dp[0][n-1]=grid[0][n-1];
        for(int i=n-2;i>=0;i--){
            dp[0][i]=grid[0][i]+dp[0][i+1];
        }
        for(int i=1;i<m;i++){
            dp[i][n-1]=grid[i][n-1]+dp[i-1][n-1];
        }
        for(int i=1;i<m;i++){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=grid[i][j]+Math.min(dp[i][j+1],dp[i-1][j]);
            }
        }
        return dp[0][n-1];
    }
    public String simplifyPath(String path) {
        String s[]=path.split("/");
        Deque<String> de=new LinkedList<>();

        for(int i=0;i<s.length;i++){
            if(s[i].equals("")||s[i].equals(".")){
                continue;
            }
            if(s[i].equals("..")){
                if(!de.isEmpty()){
                    de.pop();
                }
            }else{
                de.push(s[i]);
            }
        }
        StringBuffer sb=new StringBuffer();
        while(!de.isEmpty()){
            sb.append("/");
            sb.append(de.pollFirst());
        }
        if(sb.length()==0){
            sb.append("/");
        }
        return sb.toString();
    }
    public String[] permutation(String s) {
        List<String> ret = new ArrayList<String>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        do {
            ret.add(new String(arr));
        } while (nextPermutation(arr));
        int size = ret.size();
        String[] retArr = new String[size];
        for (int i = 0; i < size; i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }

    public boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> hs=new HashSet<>();
        for(String s:deadends){
            hs.add(s);
        }
        return 0;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p0=0;
        int p1=n-1;
        for(int i=0;i<=p1;i++){
            while(i>=0&&nums[i]==2){
                int tmp=nums[i];
                nums[i]=nums[p1];
                nums[p1]=tmp;
                p1--;
            }
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=tmp;
                p0++;
            }

        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((i>>j)&1)==1){
                    ls.add(nums[j]);
                }
            }
            res.add(ls);
        }
        return res;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ls=new ListNode(0);
        ls.next=head;
        ListNode pre=ls;
        ListNode child=ls;
        while(pre.next!=null&&pre.next.next!=null){
            if(pre.next.val==pre.next.next.val){
                child=pre.next.next;
                while(child.next!=null&&child.next.val==pre.next.val){
                    child=child.next;
                }
                pre.next=child.next;
            }else{
                pre=pre.next;
            }
        }
        return ls.next;
    }
    public int compareVersion(String version1, String version2) {
        String s[]=version1.split("\\.");
        String s2[]=version2.split("\\.");
        int n=s.length<s2.length?s.length:s2.length;
        for(int i=0;i<n;i++){
            if(Integer.parseInt(s[i])<Integer.parseInt(s2[i])){
                return -1;
            }else if(Integer.parseInt(s[i])>Integer.parseInt(s2[i])){
                return 1;
            }
        }
        if(s.length>n){
            for(int i=n;i<s.length;i++){
                if(Integer.parseInt(s[i])>0){
                        return 1;
                }
            }
        }else{
            for(int i=n;i<s2.length;i++){
                if(Integer.parseInt(s2[i])>0){
                    return -1;
                }
            }
        }
        return 0;
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode h=new ListNode(0,head);
        ListNode ru=h.next;
        ListNode pre=h;
        ListNode divide=h;
        while (ru!=null){
            if(ru.val<x){
                ListNode tmp=ru.next;
                ru.next=divide.next;
                divide.next=ru;
                divide=divide.next;

                pre.next=tmp;
            }
            ru=ru.next;
            pre=pre.next;
        }
        return h.next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(headA.val!=headB.val){
            if(headA.next==null){
               headA=a;
            }else{
                headA=headA.next;
            }
            if(headB.next==null){
                headB=b;
            }else{
                headB=headB.next;
            }
        }
        return headA;
    }

    List<List<Integer>> ls=new ArrayList<>();
    Deque<Integer> de=new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        de.addLast(0);
        dfs(graph,0,graph.length-1);
        return ls;
    }
    public void dfs(int gragh[][],int x,int n){
        if(x==n){
            ls.add(new ArrayList<>(de));
            return;
        }else{
            for(int y:gragh[x]){
                de.addLast(y);
                dfs(gragh,y,n);
                de.pollLast();
            }
        }
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int l=0,r=people.length-1;
        for(int i=r;i>=l;i--){
            if(people[i]+people[l]<=limit){//1,2,2,3
                l++;
                ans++;
            }else{
                ans++;
            }
        }
        return ans;
    }
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> q=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length()!=b.length()){
                    return a.length()-b.length();
                }else{
                    int n=a.length(),index=0;
                    while(index<n){
                        if(a.charAt(index)!=b.charAt(index)){
                            return a.charAt(index)-b.charAt(index);
                        }else{
                            index++;
                        }
                    }
                }
                return 0;
            }
        });
        for(int i=0;i<nums.length;i++){
            q.add((nums[i]));
        }
        String sb=new String();
        for(int i=0;i<k;i++){
            sb=q.poll();
        }
        return sb;
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int answer[]=new int [n];
        int count[]=new int[n+1];
        for(int i=0;i<bookings.length;i++){
            count[bookings[i][0]-1]+=bookings[i][2];
            count[bookings[i][1]]-=bookings[i][2];
        }
        answer[0]=count[0];
        for(int i=1;i<answer.length;i++){
            answer[i]=answer[i-1]+count[i];
        }
        return answer;
    }
}
