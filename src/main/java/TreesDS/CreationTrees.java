/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreesDS;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author DELL
 * Creation of Binary Tree and level Order traversal, Reverse Level order Traversal
 */
public class CreationTrees {
    static Scanner sc = new Scanner(System.in);
    static class Node{
        int data;
        Node l;
        Node r;
        
        public Node(int d){
            this.data=d;
            this.l = null;
            this.r=null;
        }
    }
    
    public static void levelOrderTraversal(Node root){
        Queue<Node> que = new LinkedList<>();
        
        que.add(root);
        que.add(null);
        
        while(!que.isEmpty()){
            Node frontEle = que.peek();
            que.poll();
            
            if(frontEle==null){
                System.out.println();
                
                if(!que.isEmpty()){
                    que.add(null);
                }
            }
            else{
                System.out.print(frontEle.data+" ");
                if(frontEle.l != null){
                    que.add(frontEle.l);
                }
                if(frontEle.r != null){
                    que.add(frontEle.r);
                    
                }
                
            }
            
            
            
        }
    }
    
    public static void reverseLevelOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        // Adding ele in que for level order travarsal and storing poll element 
        //in stack for reverse order traversal
        
        while(!que.isEmpty()){
            Node frontEle = que.peek();
            que.poll();
            
            
            if(frontEle==null){
                System.out.println();
                if(!que.isEmpty()){
                    stack.add(frontEle); // adding null element in stack
                    que.add(null);
                }
            }
            else{
                stack.add(frontEle); // adding pop element from queue in stack
                System.out.print(frontEle.data+" ");
                if(frontEle.l!=null){
                    que.add(frontEle.l);
                }
                if(frontEle.r != null){
                    que.add(frontEle.r);
                }
            }
        }
        System.out.println("Printing in Reverse Order");
        System.out.println();
        // Removing from stack and printing in reverse Order
        
        while(!stack.isEmpty()){
            Node popEle = stack.pop();
            if(popEle==null){
                System.out.println();
            }
            else{
                System.out.print(popEle.data+" ");
            }
        }
    }
    
    public static Node createBinary(Node root){
        
        
        
        System.out.println("Enter data ");
        int d = sc.nextInt();
        if(d==-1){
            return null;
        }
        root = new Node(d);
        
        

        System.out.println("Enter data for left of "+root.data);
        root.l = createBinary(root.l);

        System.out.println("Enter data for right of "+root.data);
        root.r = createBinary(root.r);
            
        return root;
            
    }
    
    public static void inOrderTraversal(Node root){
        if(root==null) return;
        
        inOrderTraversal(root.l);
        System.out.print(root.data+" ");
        inOrderTraversal(root.r);
    }
    
    public static void preOrderTraversal(Node root){
        if(root == null) return;
        
        System.out.print(root.data + " ");
        preOrderTraversal(root.l);
        preOrderTraversal(root.r);
        
        
        
    }
    public static void postOrderTraversal(Node root){
        if(root == null) return;
        
        postOrderTraversal(root.l);
        postOrderTraversal(root.r);
        System.out.print(root.data + " ");
    }
    
    public static void buildLevelOrderTraversal(Node root){
        Queue<Node> que = new LinkedList<>();
        System.out.println("Enter data for root");
        int data = sc.nextInt();
        
        root = new Node(data);
        
        que.add(root);
        
        while(!que.isEmpty()){
            Node temp = que.poll();
            
            System.out.println("Enter data for left of "+temp.data);
            data = sc.nextInt();
            temp.l = new Node(data);
            que.add(temp.l);
            
            System.out.println("Enter data for right of "+temp.data);
            data = sc.nextInt();
            temp.r = new Node(data);
            que.add(temp.r);
        }
    }
    
    public static void main(String[] args) {
        Node root = null;
        
        root = createBinary(root);
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        System.out.println("Root "+root.data);
//        levelOrderTraversal(root);
//        reverseLevelOrderTraversal(root);
//        inOrderTraversal(root);
//        preOrderTraversal(root);
        postOrderTraversal(root);
    }
}
