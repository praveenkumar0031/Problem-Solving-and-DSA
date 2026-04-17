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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] res=new int[m][n];
        int top = 0,bottom = m - 1,left = 0,right = n - 1;
        
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res[top][i]=-1;
                if(head!=null){
                    res[top][i]=head.val;
                    head=head.next;
                }
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res[i][right]=-1;
                if(head!=null){
                    res[i][right]=head.val;
                    head=head.next;
                }
                
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res[bottom][i]=-1;
                    if(head!=null){
                    res[bottom][i]=head.val;
                    head=head.next;
                    }
                }
                bottom--;
            }
           if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] =-1;
                    if(head!=null){
                    res[i][left]=head.val;
                    head=head.next;
                    }
                }
                left++;
            }
        }
        return res;
    }
}

