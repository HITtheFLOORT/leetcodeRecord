public class SingleLiat {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l=null;
        ListNode head=null;
        int ji=0;
        while(l1!=null||l2!=null) {
            int b = l1.next == null ? 0 : l1.val;
            int a = l2.next == null ? 0 : l2.val;
            int k = a + b + ji;
            int yu = k % 10;
            ji = k / 10;
            if (l == null) {
                l = head = new ListNode(yu);
            } else {
                l.next = new ListNode(yu);
                l = l.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ji > 0) {
            l.next = new ListNode(ji);
        }
        return head;
    }
}
