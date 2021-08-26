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


}