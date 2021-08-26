import java.sql.ClientInfoStatus;
import java.util.HashMap;

public class LRU {
    private int capacity=0;
    private HashMap<Integer,MyNode> map=new HashMap<>();
    private DoubleLinkedlist dl=new DoubleLinkedlist();
    public LRU(int capacity){
        this.capacity=capacity;
    }
    public int get(int key){
        if(map.containsKey(key)){
            MyNode no=map.get(key);
            dl.move(no);
            return (int)no.value;
        }else{
            return -1;
        }
    }
    public void put(int key, int val){
        if(map.containsKey(key)){
            MyNode no=map.get(key);
            no.value=val;
            dl.move(no);
        }else{
            if(map.size()==capacity){
                MyNode head=dl.getHead();
                map.remove((int)head.key);
                dl.removeMyNode(head);

                MyNode newNode=new MyNode(key,val);
                dl.add(newNode);
                map.put(key,newNode);
            }else{
                MyNode newNode=new MyNode(key,val);
                dl.add(newNode);
                map.put(key,newNode);
            }
        }

    }
}
class MyNode{
    Object key;
    Object value;
    MyNode pre=null;
    MyNode next=null;
    MyNode(Object k,Object v){
        key=k;
        value=v;
    }
}
class DoubleLinkedlist{
    private MyNode head=new MyNode(null,null);
    private MyNode tail=head;
    public void add(MyNode myNode){
        tail.next=myNode;
        myNode.pre=tail;
        tail=myNode;
    }
    public MyNode getHead(){
        return head.next;
    }
    public void removeMyNode(MyNode myNode){
        myNode.pre.next=myNode.next;
        if(myNode.next!=null){
            myNode.next.pre=myNode.pre;
        }else{
            tail=myNode.pre;
        }
        myNode.pre=null;
        myNode.next=null;
    }
    public void move(MyNode myNode){
        removeMyNode(myNode);
        add(myNode);
    }
}