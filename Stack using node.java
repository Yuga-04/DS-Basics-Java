import java.util.*;
class node{
    int data;
    node next;
    node(int val){
        data=val;
    }
}
public class Stack{
    static node head=null;
    void push(int val){
        node nn = new node(val);
        nn.next=head;
        head=nn;
    }
    void pop(){
        if(head!=null){
        node temp= head.next;
        head.next=null;
        head=temp;
    }
        else{
            System.out.print("Stack is Empty");
        }
    }
    int peek(){
           return head.data;
    }
    boolean isEmpty(){
        return head==null;
    }
    void disp(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    void Ssize(){
        int count=0;
        node temp=head;
        if(temp==null){
            System.out.println("Stack is Empty");
        }
        else{
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.printf("Size of Stack: %d", count);
        System.out.println();}
    }
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        Stack obj=new Stack();
        System.out.println("1 . Push an element in Stack.\n2 . Pop an element in Stack.\n3 . Check Whether the Stack is Empty or Not. \n4 . Peek an element in Stack. \n5 . Size of the Stack. \n6 . Display Stack. \n0 . STOP");
        while(true){
            System.out.print("Enter your Choice: ");
            int choice = z.nextInt();
            if(choice==1){
                int num=z.nextInt();
                obj.push(num);
            }
            else if(choice==2){
                obj.pop();
                System.out.println("Element Popped");
            }
            else if(choice==3){
                    System.out.println((obj.isEmpty())?"Empty":"Not Empty");
            }
            else if(choice==4){
                System.out.println(obj.peek());
            }
            else if(choice==5){
                obj.Ssize();
            }
            else if(choice==6){
                obj.disp();
            }
            else if(choice==0){
                System.out.println("Stopped");
                break;
            }
            else{
                System.out.println("Enter the correct choice: ");
            }
        }
    }
}