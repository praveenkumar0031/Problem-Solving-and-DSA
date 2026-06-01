/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode it=headA;
        while(it!=null && it.next!=null){
            lenA+=2;
            it=it.next.next;
        }
        
        if(it!=null)
            lenA++;
        it=headB;
        while(it!=null && it.next!=null){
            lenB+=2;
            it=it.next.next;
        }
        if(it!=null)
            lenB++;
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        
        while(headA!=null){
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}