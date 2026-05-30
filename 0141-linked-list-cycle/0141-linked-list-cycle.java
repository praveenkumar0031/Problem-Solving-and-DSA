/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null)
            return false;
        ListNode end=head;
        while(end!=null &&end.next!=null){
            head=head.next;
            end=end.next.next;
            if(head==end)
                return true;
        }
        return false;
    }
}