import java.util.*;
class node{
    int data;
    node next;
    node(int val){
        data=val;
    }
}
public class Queueull{
     static node head=null;
     static node last=null;
     void enque(int val){
        node nn=new node(val);
        if(head==null){
            head=nn;
            last=nn;
            return;
        }
        last.next=nn;
        last=nn;
     }
     void deque(){
        node temp=head.next;
        head=null;
        head=temp;
     }
     void disp(){
        node temp=head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
     }
     public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        Queueull obj=new Queueull();
        System.out.println("1 . Enque an element in Queue.\n2 . Dequeue an element in Queue.\n3 . Display Queue. \n0 . STOP");
        while(true){
            System.out.print("Enter your Choice: ");
            int choice = z.nextInt();
            if(choice==1){
                int num=z.nextInt();
                obj.enque(num);
            }
            else if(choice==2){
                obj.deque();
                System.out.println("Element Dequeued");
            }
            else if(choice==3){
                    obj.disp();
            }
            else{
                return ;
            }
        }
     }
}