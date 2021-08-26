public class Bytecompute {
    public Bytecompute(){

    }
    static int b=11;
    private int a=10;
    public int singleNumber(int nums[]){
        int ons=0,two=0;
        for(int num:nums){
            ons=ons^num&~two;
            two=two^num&~ons;
        }
        return ons;
    }
}
class Bytenum extends Bytecompute{

}
