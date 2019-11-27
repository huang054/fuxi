package forkjoin;

public class NodeMerge {
    static class Node {
        private final int date;
        public  Node next;


        public Node(int date, Node next) {
            this.date = date;
            this.next = next;
        }
    }
    protected static Node merge(Node node1,Node node2){
        if (node1==null)
            return node2;
        if (node2==null)
            return node1;
        Node head =new Node(0,null);
        Node curr =head;
        Node nodeA=node1;
        Node nodeB=node2;
        while (nodeA!=null&&nodeB!=null){
            if(nodeA.date<=nodeB.date){
               curr.next=nodeA;

               nodeA=nodeA.next;
            }else{
               curr.next=nodeB;

               nodeB=nodeB.next;
            }
            curr=curr.next;

        }
        if (nodeA==null)
            curr.next=nodeB;
        if (nodeB==null){
            curr.next= nodeA;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node node1=new Node(34, null);
        Node node2=new Node(30, node1);
        Node node3=new Node(13, node2);
        Node node4=new Node(6, node3);

        Node root=new Node(3, node4);

        Node node5=new Node(32, null);
        Node node6=new Node(23, node5);
        Node node7=new Node(13, node6);
        Node node8=new Node(5, node7);

        Node root1=new Node(1, node8);
        Node node=merge(root1,root);
        Node head=node;
        while(head!=null){
            System.out.println(head.date);
            head=head.next;
        }
    }
}
