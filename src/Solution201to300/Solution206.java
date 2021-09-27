package Solution201to300;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
