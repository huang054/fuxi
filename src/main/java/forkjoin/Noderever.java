package forkjoin;

public class Noderever {
    static class Node {
        private final Object date;
        public  Node next;


        public Node(Object date, Node next) {
            this.date = date;
            this.next = next;
        }
    }
        public static void main(String[] args) {
            Node node1=new Node(5, null);
            Node node2=new Node(4, node1);
            Node node3=new Node(3, node2);
            Node node4=new Node(2, node3);

            Node root=new Node(1, node4);
            Node head=root;
            while(head!=null){
                System.out.println(head.date);
                head=head.next;
            }
            head=revser(root);
            while(head!=null){
                System.out.println(head.date);
                head=head.next;
            }



        }
        private static Node revser(Node node){
        Node pre=null;
        Node now=node;
        while (now!=null){
            Node next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
         return pre;
        }
    }

