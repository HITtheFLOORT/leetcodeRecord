package Solution1to100;



public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pos=0;

        ListNode ans0=new ListNode();
        ListNode ans=ans0;
        while(l1!=null&&l2!=null){

            int sum=pos+l1.val+l2.val;
            pos=sum>=10?1:0;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int sum=pos+l1.val;
            pos=sum>=10?1:0;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            l1=l1.next;
        }
        while(l2!=null){

            int sum=pos+l2.val;
            pos=sum>=10?1:0;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            l2=l2.next;
        }
        if(pos!=0){
            ans.next=new ListNode(pos);
        }
        return ans0.next;
    }
}
