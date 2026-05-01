/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode fast=head;
        ListNode slow=head;
        ListNode prevslow = null;
        if(head==null||head.next==null)
            return;
        while(fast!=null && fast.next!=null){
            prevslow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if (prevslow != null) 
            prevslow.next = null;
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode t= curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        while(head!=null && prev!=null){
             ListNode t =head.next;
             ListNode p =prev.next;
             head.next=prev;
             if(t==null)
                break;
             prev.next=t;
             head=t;
             prev=p;
            
        }
        
    }
}