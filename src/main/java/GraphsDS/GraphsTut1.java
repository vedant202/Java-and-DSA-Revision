/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphsDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GraphsTut1 {
    static HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
    
    
    public static void addEdge(int u,int v,int direction){
        ArrayList<Integer> temp = new ArrayList<>();
        
        temp.add(v);
        
        
        if(!graph.containsKey(u))
        {
            graph.put(u, new ArrayList<>());
        }
        if(!graph.containsKey(v))
        {
            graph.put(v, new ArrayList<>());
        }
        
        graph.get(u).add(v);
        
        
        if(direction == 0){
//            temp=null;
//            temp = new ArrayList<>();
//            temp.add(u);
//            graph.put(v, temp);
            
            
                graph.get(v).add(u);
            
        
        }
    }
    
    public static void printGraph(){
        for(var i : graph.entrySet()){
            System.out.println(i.getKey()+ " -> ");
            for(var j:i.getValue()){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();
        
        System.out.println("Enter no of Edges");
        int m = sc.nextInt();
        
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
//            int v = sc.nextInt();
            addEdge(u, v, 0);
        }
        
        printGraph();
        
        
        
    }
}
