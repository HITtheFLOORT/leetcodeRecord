package Solution300plus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        List<int[]> frac=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                frac.add(new int[]{arr[i],arr[j]});
            }
        }
        Collections.sort(frac,(x,y)->(x[0]*y[1]-x[1]*y[0]));
        return frac.get(k-1);
    }

}
