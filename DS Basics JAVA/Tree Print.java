import java.io.*;
import java.util.*;
class node{
    int data;
    node left,right,root;
    node(int val){
        data=val;
    }
}

public class Solution {
    static node root=null;
    static node left=null;
    static node right=null;
    
    node Tree(String[] str){
        Queue<node> que=new LinkedList<>();
        node root= new node(Integer.parseInt(str[0]));
        que.add(root);
        int i=1,ele;
        while(!que.isEmpty()){
            node t=que.poll();
            ele=Integer.parseInt(str[i++]);
            if(ele!=-1){
                node nn=new node(ele);
                t.left=nn;
                que.add(nn);
            }
            ele=Integer.parseInt(str[i++]);
            if(ele!=-1){
                node nn=new node(ele);
                t.right=nn;
                que.add(nn);
            }
        }
        return root;
    }
    
    //INORDER TRAVERSAL
    void inorder(node t){
        if(t!=null){
            inorder(t.left);
            System.out.print(t.data+" ");
            inorder(t.right);
        }
    }
    
    //PREORDER TRAVERSAL
    void preorder(node t){
        if(t!=null){
            System.out.print(t.data+" ");
            preorder(t.left);
            preorder(t.right);
        }
    }
    
    //POSTORDER TRAVERSAL
    void postorder(node t){
        if(t!=null){
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.data+" ");
        }
    }
    //LEVEL ORDER
    void levelorder(node t){
        Queue<node> que=new LinkedList<>();
        que.add(t);
        while(!que.isEmpty()){
             node p=que.poll();
             System.out.print(p.data+" ");
             if(p.left!=null) que.add(p.left);
             if(p.right!=null) que.add(p.right);
        }
    }
    //count Nodes
    int count(node t){
        if(t==null){
            return 0;
        }
        return 1+count(t.left)+count(t.right);
    }
    
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        Solution obj=new Solution(); 
        String str[]=z.nextLine().split(" ");
        node root=obj.Tree(str);
        int c=0;
        System.out.print(obj.count(root));
    }
}