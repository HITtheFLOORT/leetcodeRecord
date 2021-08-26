public class Tips {
    /*
    可以通过位运算x &= (x - 1)确定1的个数
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
