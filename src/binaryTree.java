import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data=data;
        left=null;
        right=null;
    }
}
public class binaryTree {


static Node insert(Node root,int data) {
    if(root==null)
        root=new Node(data);
    else if(data<root.data) {
    if(root.left==null)
        root.left=new Node(data);
    else
        insert(root.left,data);
    }
    else {
        if(root.right==null)
            root.right=new Node(data);
        else
            insert(root.right,data);
    }
    return root;
}

static void preOrder(Node root) {
    if(root==null)
        return;
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
}

static void postOrder(Node root) {
    if(root==null)
        return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
}

    static void inOrder(Node root) {
        if(root==null)
            return;
        postOrder(root.left);
        System.out.println(root.data);
        postOrder(root.right);

    }
static Node delete(Node root,int data) {
    if(root==null)
        return null;
    else if(data<root.data)
        root.left=delete(root.left,data);
    else if(data>root.data)
        root.right=delete(root.right,data);
    else{
       if(root.left==null || root.right==null){
           Node temp=null;
           temp=root.left==null?root.right:root.left;
           if(temp==null)
               return null;
           else return temp;
       }
       root.data=getSuccessor(root.right);
        root.right=delete(root.right,root.data);
        return root;
    }
    return root;
}
static int getSuccessor(Node root) {
        while(root.left!=null)
            root=root.left;
        return root.data;
}

    public static void main(String[] args) {
        Node root=null;
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<6;i++) {
            root = insert(root,sc.nextInt());
        }
   // preOrder(root);
     //   postOrder(root);
        preOrder(root);
        delete(root,13);
preOrder(root);
    }
}
