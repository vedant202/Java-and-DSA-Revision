/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts;

/**
 *
 * @author DELL
 */
public class Recurssion1 {
    
    public static int Fibonacci(int num){
        if(num<=1) return num;
        System.out.println("Num "+num);
        return Fibonacci(num-1) + Fibonacci(num-2);
    }
    
    public static int Fibonacci(int num,int[] memo){
        if(num<=1) return num;
        
        if(memo[num-1]==-1){
            System.out.println("Num "+num);
            memo[num-1] = Fibonacci(num-1,memo);
            
        }
        if(memo[num-2]==-1){
            memo[num-2] = Fibonacci(num-2,memo);
        }
        return memo[num-1]+memo[num-2];
    }
    public static void main(String[] args) {
        
        int num = 100;
        
        int memo[] = new int[num+1];
        for(int i=0;i<=num;i++){
            memo[i] = -1;
        }
        
        int series = Fibonacci(num,memo);
        System.out.println(series);
    }

     
}
