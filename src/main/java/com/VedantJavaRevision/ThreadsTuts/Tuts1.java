/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.ThreadsTuts;

/**
 *
 * @author DELL
 */

class A extends Thread{
    
    public void run(){
//        int num=0;
        for(int i=0;i<100;i++){
            System.out.println("Hii");
        }
    }
}

class B extends Thread{
    
    public void run(){
//        int num=0;
        for(int i=0;i<100;i++){
            System.out.println("Hello");
        }
    }
}
public class Tuts1 {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        
        a.start();
        b.start();
        
//        System.out.println("Hello");
    }
}
