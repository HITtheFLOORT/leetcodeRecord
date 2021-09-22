package Solution201to300;

public class Solution274 {
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
}
