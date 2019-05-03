 class Employee{
    int id;
    String name;
    Employee(int id,String name){
        this.id=id;
        this.name=name;
    }
public String toString(){
        return id+" "+name;
    }
}
class Node1{
    Employee data;
    Node1 next;
    Node1(Employee data) {
        this.data = data;
        next = null;
    }
}
public class CircularList {

    static Node1 head = null;

    static boolean isEmpty() {
        return head == null;

    }

    static void insertAtBeg(Employee data) {
        if (isEmpty()) {
            head = new Node1(data);
            head.next=head;
        } else
            System.out.println("List not empty");
    }

    static void insert(Employee data) {
        if(head==null) {
            head = new Node1(data);
            head.next=head;
        }
        else {
        Node1 a= new Node1(data);
        Node1 temp=head;
        while(temp.next!=head)
            temp=temp.next;

        temp.next=a;
        a.next=head;
        }
    }

    static int length() {
        Node1 temp=head;
        int l=1;
        while(temp.next!=head) {
            l++;
            temp=temp.next;

        }return l;
    }

    static void deletionAtPos(int pos) {
        if(pos==1) {
            Node1 temp=head;
            while(temp.next!=head)
                temp=temp.next;
            temp.next=head.next;
            Node1 a=head;
            head=head.next;
            a.next=null;
        }
        else if(pos>length()+1)
            System.out.println("invalid range");
        else {
            Node1 temp=head;
            Node1 previous=null;
            if(pos==length())
            {
                while(temp.next!=head){
                    previous =temp;
                    temp=temp.next;}
                previous.next=head;
                temp.next=null;
            }
            else {
                for(int i=1;i<pos;i++) {
                    previous = temp;
                    temp = temp.next;
                }
                previous.next=temp.next;
                temp.next=null;
            }
        }
    }

    static void display() {
        Node1 temp = head;
        while (true) {
            System.out.print("->" + temp.data );
            temp = temp.next;
            if(temp==head)
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Employee obj1=new Employee(1,"vivek");
        Employee obj2=new Employee(2,"anshu");
        Employee obj3=new Employee(3,"chirag");
        insert(obj1);
        insert(obj2);
        insert(obj3);
        display();
        deletionAtPos(2);
        display();
    }
}
