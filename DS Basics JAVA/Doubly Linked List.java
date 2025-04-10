import java.util.*;
class node{
    int data;
    node next;
    node prev;
    node(int val){
        data=val;
    }
}
public class Solution{
    static node head=null;
    static node last=null;
    void ins(int val){
        node nn=new node(val);
        if(head==null){
            head=nn;
            last=nn;
            last.next=head;
            head.prev=last;
            return;
        }
        last.next=nn;
        nn.prev=last;
        last=nn;
        head.prev=last;
        last.next=head;
    }
    boolean search(int val){
        if(head==null) return false;
        if(head.data==val) return true;
        else{
            node temp=head.next;
            while(temp!=head){
                if(temp.data==val) return true;
                temp=temp.next;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution obj=new Solution();
        Scanner z = new Scanner(System.in);
        while(z.hasNext()){
            int val=z.nextInt();
            if(val==-1){
                break;
            }
            obj.ins(val);
        }
        System.out.print("Enter the element to Search : ");
        int ele=z.nextInt();
        System.out.println((obj.search(ele))?"Found":"Not Found");
    }
}