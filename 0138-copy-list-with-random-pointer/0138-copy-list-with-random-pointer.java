/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> hm=new HashMap<>();
        Node t=head;
        while(t!=null){
            hm.put(t,new Node(t.val));
            t=t.next;
        }
        t=head;
        Node newHead=hm.get(head);
        while(t!=null){
            hm.get(t).next=hm.get(t.next);
            hm.get(t).random=hm.get(t.random);
            t=t.next;
        }
        return newHead;
    }
}