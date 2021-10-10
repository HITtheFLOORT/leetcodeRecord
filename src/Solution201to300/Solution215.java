package Solution201to300;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> cmp;
        cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
// 建立最大堆
        Queue<Integer> q = new PriorityQueue<Integer>(cmp);
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }
        return q.poll();
    }

}
