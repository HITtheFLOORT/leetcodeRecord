import java.util.*;

public class Middle {
    public int maxValue(int[][] grid) {
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
               if(i==0&&j==0){continue;}
               if(i==0){grid[i][j]+=grid[i][j-1];}
               else if(j==0){grid[i][j]+=grid[i-1][j];}
               else{grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);}
            }
        }
        return grid[grid[0].length-1][grid.length-1];
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if (k * m > bloomDay.length) {
            return -1;
        }
        int low = 1, high = 1;
        int length = bloomDay.length;
        for (int i = 0; i < length; i++) {
            high = Math.max(high, bloomDay[i]);
        }

        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int sumw=sum/2;
        for(int i=0;i<n;i++){
            for(int j=sumw;j>=stones[i];j--){
                dp[j]=dp[j]||dp[j-stones[i]];
            }
        }
        for (int j = sumw;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
    public int hIndex(int[] citations) {
        int n=citations.length;
        int count[]=new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int tot=0;
        for (int i = n; i >= 0; i--) {
            tot += count[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;

    }
    public int search(int[] nums, int target) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        while(left<right){
            int mid=(right+left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        int ans=0;
        for(int i=left;i<n;i++){
            if(nums[i]==target){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        HashMap<Integer,Integer> hs=new HashMap();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int a:arr){
            hs.put(a, hs.getOrDefault(a,0)+1);
            max=a>max?a:max;
            min=a<min?a:min;
        }
        if(min!=1){
            if(hs.get(min)>1){
                hs.put(1,1);
            }
        }
        int n=hs.size();
        if(max>n){
            return n;
        }else{
            return max;
        }
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        int a[]=new int[26];
        for(int i=0;i<brokenLetters.length();i++){
            a[brokenLetters.charAt(i)-'a']++;
        }
        int ans=0;
        boolean flag=true;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                if(flag==true){
                    ans++;
                }else{
                    flag=true;
                }
                continue;
            }
            if(a[text.charAt(i)-'a']>0){
                flag=false;
            }

        }
        if(flag==true){
            ans++;
        }
        return ans;
    }
    public List<Integer> pathInZigZagTree(int dist) {
        int a=dist;
        int pos=0;
        for(int i=0;i<32;i++){
            if(dist>>i==0){
                a=1<<i-1;
                pos=i;
                break;
            }
        }
        List<Integer> ls=new LinkedList<>();
        ls.add(dist);
        for(int i=1;i<pos;i++){
            if(pos-i!=1){
                int sum=(1<<(pos-i))+(1<<(pos-i-1))-1;
                dist=sum-dist/2;
                ls.add(dist);
            }else{
                ls.add(1);
            }
        }
        Collections.reverse(ls);
        return ls;
    }
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>(){
            {
                add(0);
            }
        };
        int head=1;
        for(int i=0;i<n;i++){
            for(int j=res.size()-1;j>=0;j--){
                res.add(head+res.get(j));
            }
            head<<=1;
        }
        return res;
    }
    public boolean escapeGhosts(int[][] ghosts, int[] target) {//0,-1,0,3
                                                                //1,0,0,0
                                                                //0,0,0,0
                                                                //0,0,0,0,
        int escapedis=mahaton(0,0,target[0],target[1]);
        for(int i=0;i<ghosts.length;i++){
            int x=ghosts[i][0];
            int y=ghosts[i][1];
            int dis=mahaton(x,y,target[0],target[1]);
            if(dis<=escapedis){
                return false;
            }
        }
        return true;
    }
    public int mahaton(int x,int y,int targetx,int targety){

        return Math.abs(x-targetx)+Math.abs(y-targety);
    }
    int max;
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();

    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
    boolean isValidflag=true;
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> de=new LinkedList<>();
        double inorder=-Double.MAX_VALUE;
        while(!de.isEmpty()||root!=null){
            while(root!=null){
                de.push(root);
                root=root.left;
            }
            root=de.pop();
            if(root.val<=inorder){
                return false;
            }
            inorder= root.val;
            root=root.right;
        }
        return true;
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int curr=0;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> qu=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<k;++i){
            while(curr<n&&arr[curr][0]<=w){
                qu.add(arr[curr][1]);
                curr++;
            }
            if(!qu.isEmpty()){
                w+=qu.poll();
            }else{
                break;
            }
        }
        return w;
    }
    public void recoverTree(TreeNode root){
        List<Integer> nums=new ArrayList<>();
        inorder(root,nums);
        int []ans=findTwo(nums);
        recover(root,2,ans[0],ans[1]);
    }
    public void inorder(TreeNode root,List<Integer> nums){
        if(root==null){
            return;
        }
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    public int[] findTwo(List<Integer> nums){
        int n=nums.size();
        int index1=-1,index2=-1;
        for(int i=0;i<n-1;i++){
            if(nums.get(i+1)<nums.get(i)){
                index2=i+1;
                if(index1==-1){
                    index1=i;
                }else{
                    break;
                }
            }
        }
        int x=nums.get(index1),y= nums.get(index2);
        return new int[]{x,y};
    }
    public void recover(TreeNode root,int count,int x,int y){
        if(root!=null){
            if(root.val==x||root.val==y){
                root.val=root.val==x?y:x;
                if(--count==0){
                    return;
                }
            }
            recover(root.right,count,y,x);
            recover(root.left,count,x,y);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int len=0;
        int index=0;
        int kong=0;
        int klen=maxWidth;
        while(index<words.length){
            List<String> tmp=new ArrayList<>();
            while(index<words.length&&len<maxWidth){
                if(words[index].length()+len+1<=maxWidth){
                    len+=words[index].length()+1;
                    tmp.add(words[index]);
                    kong++;
                    klen-=words[index].length();
                    index++;
                }else{
                    len+=words[index].length()+1;
                }
            }
            StringBuffer sb=new StringBuffer(tmp.get(0));
            kong=kong>0?kong-1:0;
            if(kong!=0&&klen%kong!=0){
                sb.append(" ");
            }else if(kong==0){
                sb.append(sbnum(klen));
            }
            for(int i=1;i<tmp.size();i++){
                sb.append(sbnum(klen/kong));
                sb.append(tmp.get(i));
            }
            ans.add(sb.toString());
            len=0;
            kong=0;
            klen=maxWidth;
        }
        return ans;

    }
    private  StringBuffer sbnum(int a){
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<a;i++){
            ans.append(" ");
        }
        return ans;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        Deque<TreeNode> de=new LinkedList<>();
        if(root!=null){
            de.add(root);
        }else {
            return ls;
        }
        while(!de.isEmpty()){
            int layersize=de.size();
            List<Integer> layer=new ArrayList<>();
            while(layersize-->0){
                TreeNode tmp=de.pollFirst();
                layer.add(tmp.val);
                if(tmp.left!=null){
                    de.add(tmp.left);
                }
                if(tmp.right!=null){
                    de.add(tmp.right);
                }
            }
            ls.add(layer);
        }
        return ls;
    }
    public int chalkReplacer(int[] chalk, int k) {
        int sum[]=new int[chalk.length];
        for(int i=0;i<sum.length;i++){
            if(i==0){
                sum[i]=chalk[i];
            }else{
                sum[i]=sum[i-1]+chalk[i];
            }
            if (sum[i] > k) {
                return i;
            }
        }
        k%=sum[sum.length-1];
        int l=0;
        int r=sum.length-1;
        while(l<r){
            int mid=(l+(r-l))/2;
            if(sum[mid]<=k){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    public int findIntegers(int n) {
        int pos=1;
        while((n>>pos)>0){
            pos++;
        }
        int tmp=0;
        int p=1;
        int q=2;
        if(pos<2){
           return pos+1;
        }
        for(int i=2;i<=5;i++){
            tmp=p;
            p=q;
            q=tmp+p;
        }
        return q;
    }
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int n[]=new int[10000];
        for(int i=0;i<source.length;i++){
            for(int j=0;j<source[0].length;j++){
                n[source[i][j]]++;
                n[target[i][j]]--;
            }
        }
        int ans=0;
        for(int i=0;i<n.length;i++){
            if(n[i]!=0)
            {ans+=Math.abs(n[i]);}
        }
        return ans/2;
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        for(int []p:points){
            Map<Integer,Integer> ma=new HashMap<>();
            for(int []q:points){
                int dis=(p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
                ma.put(dis,ma.getOrDefault(dis,0)+1);
            }
            for(Integer a:ma.values()){
                ans+=a*(a-1);
            }
//            for(Map.Entry<Integer,Integer> entry:ma.entrySet()){
//                int m=entry.getValue();
//                ans+=m*(m-1);
//            }
        }
        return ans;
    }
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length()!=b.length()){
                    return b.length()-a.length();
                }else{
                    return a.compareTo(b);
                }
            }
        });

        for(String word:dictionary){
            int single=0;
            int couple=0;
            while(single<s.length()&&couple<word.length()){
                if(s.charAt(single)==word.charAt(couple)){
                    couple++;
                }
                single++;
            }
            if(couple==word.length()){
                return word;
            }
        }
        return "";
    }
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(compare(nums,mid-1,mid)<0&&compare(nums,mid,mid+1)>0){
                return mid;
            }
            if(compare(nums, mid,mid+1)<0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return r;
    }
    public int compare(int []nums,int a,int b){
        if(a<0){
            return -1;
        }else if(b>=nums.length){
            return 1;
        }else{
            return nums[a]-nums[b];
        }
    }
}