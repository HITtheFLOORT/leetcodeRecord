import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder(){
        min=new PriorityQueue<Integer>((a,b)->(b-a));
        max=new PriorityQueue<Integer>((a,b)->(a-b));
    }
    public void addnum(int num){
        if(min.isEmpty()||num<=min.peek()){
            min.add(num);
            if(min.size()>max.size()+1){
                max.add(min.poll());
            }
        }else{
            max.add(num);
            if(max.size()> min.size()){
                min.add(max.poll());
            }
        }
    }
    public double findMedian(){
        if(min.size()>max.size()){
            return min.peek();
        }else{
            return (min.peek()+max.peek())/2.0;
        }
    }
}
