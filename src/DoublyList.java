import java.sql.SQLOutput;

class Node0{
    int data;
    Node0 left;
    Node0 right;
    Node0(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class DoublyList {

    static Node0 head = null;

    static boolean isEmpty() {
        return head == null;

    }

    static void insertAtBeg(int data) {
        if (isEmpty()) {
            head = new Node0(data);
        } else
            System.out.println("List not empty");
    }

    static void insert(int data) {
        if (head == null)
            head = new Node0(data);
        else {
            Node0 temp = head;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = new Node0(data);
            temp.right.left = temp;
        }
    }

    static int length() {
        Node0 temp = head;
        int l = 0;
        while (temp != null) {
            l++;
            temp = temp.right;
        }
        return l;
    }

    static void insertAtPos(int pos, int data) {
        if (pos == 1) {
            Node0 temp = head;
            head = new Node0(data);
            head.right = temp;
            temp.left = head;
        } else if (pos > length() + 1) {
            System.out.println("Out of bound");
        } else {
            Node0 temp = head;
            for (int i = 2; i < pos; i++) {
                temp = temp.right;
            }
            Node0 a = new Node0(data);
            a.left = temp;

            if (temp.right != null) {
                a.right = temp.right;
                temp.right.left = a;
            }
            temp.right = a;

        }
    }
    static void deleteAtPosition(int pos) {
        if(pos==1) {
            Node0 temp=head;
            head=head.right;
            head.left=null;
            temp.right=null;
        }
        else if(pos>length()+1)
            System.out.println("INvalid deletion");
        else {
            Node0 temp=head;
            for(int i=1;i<pos;i++)
                temp=temp.right;

            temp.left.right=temp.right;
            if(temp.right!=null)
            {
                temp.right.left=temp.left;
            }
            temp.left=null;
            temp.right=null;

        }
    }

    static void deleteData(int data) {
        Node0 temp = head;
        while (temp.data != data) {
            temp = temp.right;
        }
        if (temp == head) {
            head = temp.right;
        } else if (temp.right == null) {
            temp.left.right = null;

        } else {
            temp.right.left = temp.left;
            temp.left.right = temp.right;
        }
        temp.left = null;
        temp.right = null;


    }

    static void display() {
        Node0 temp = head;
        while (temp != null) {
            System.out.print("->" + temp.data );
            temp = temp.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertAtBeg(1);
        insert(2);
        insert(3);
        display();
//        insertAtPos(5,34);
        insert(4);
        insertAtPos(5,5);
        display();
        deleteAtPosition(2);
        display();
    }
}
