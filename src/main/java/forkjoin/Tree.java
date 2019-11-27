package forkjoin;

public class Tree {
    static class Node{
        public final int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
        }
    }
    private  Node root;

    public  Node find(int key){
        Node node=root;
        while(node!=null) {
            if (node.data < key) {
                node = node.right;
            } else if (node.data > key) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
    public  void insert(int data){
        Node node=new Node(data);
        if (root==null){
            root=node;
            return;
        }
        Node current=root;
        Node parent=null;
        while(current!=null){
            parent=current;
             if(current.data>data){
                 current=current.left;
                 if (current==null){
                     parent.left=node;
                     return;
                 }
             }else{
                 current=current.right;
                 if (current==null){
                     parent.right=node;
                    return;
                 }


             }
        }
    }
    public void pre(Node node){
        if (node!=null){
            System.out.print(node.data+" ");
            pre(node.left);
            pre(node.right);
        }
    }
    public  void middle(Node node) {
        if (node != null) {

            middle(node.left);
            System.out.print(node.data + " ");
            middle(node.right);
        }
    }
        public  void post(Node node){
            if (node!=null){

                post(node.left);
                post(node.right);
                System.out.print(node.data+" ");
            }
        }

    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.insert(67);
        tree.insert(45);
        tree.insert(78);
        tree.insert(123);
        tree.insert(66);
        tree.insert(34);
        tree.insert(68);
        tree.insert(50);
        System.out.println(tree.find(66).data);
        tree.pre(tree.root);
        System.out.println();
        tree.middle(tree.root);
        System.out.println();
        tree.post(tree.root);
    }
    }


