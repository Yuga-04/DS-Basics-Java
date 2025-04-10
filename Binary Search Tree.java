import java.io.*;
import java.util.*;
class node{
    node left,right;
    int data;
    node(int data){
        this.data=data;
    }
}
public class Solution1 {
    
    //Insertion for BST
    node ins(node root , int data){
        if(root==null){
            return new node(data);
        }
        if(data<=root.data){
            root.left=ins(root.left,data);
        }
        else{
            root.right=ins(root.right,data);
        }
        return root;
    }
    
    //Search in BST
    boolean ser(node root,int d){
        if(root==null) return false;
        if(root.data==d) return true;
        if(d<root.data) return ser(root.left,d);
        else return ser(root.right,d);
    }
    
    //Print of BST
    void disp(node root){
        if(root==null) return;
        System.out.print(root.data+":");
        if(root.left!=null)
            System.out.print("L:"+root.left.data+",");
        if(root.right!=null)
            System.out.print("R:"+root.right.data);
        System.out.println();
        disp(root.left);
        disp(root.right);
    }
    
    //Delete in BST
    node del(node root,int d){
        if(root==null) return null;
        if(d<root.data){
            root.left=del(root.left,d);
        }
        else if(d>root.data){
            root.right=del(root.right,d);
        }
        else{
          if(root.left==null && root.right==null) return null;
          else if(root.left!=null && root.right==null) return root.left;
          else if(root.left==null && root.right!=null) return root.right;
          else{
              node t=root.right;
              while(t.left!=null) t=t.left;
              root.data=t.data;
              root.right=del(root.right,t.data);
              return root;
              }
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        Solution1 obj=new Solution1();
        node root = null;
        int op=z.nextInt();
        for(int i=0;i<op;i++){ 
            int ch=z.nextInt();
            if(ch==1){
                int val=z.nextInt();
                root=obj.ins(root,val);
            }
            else if(ch==2){
                int val=z.nextInt();
                root=obj.del(root,val);
            }
            else if(ch==3){
                int val=z.nextInt();
                System.out.println(obj.ser(root,val));
            }
            else if(ch==4){
                obj.disp(root);
            }
        }
    }
}