package com.VedantJavaRevision.ThreadsTuts;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

class Counter{
    int c;
    public synchronized void count(){
        c++;
    }
}
public class RaceCondition {
    public static void main(String[] args) {
        Counter c = new Counter();
//        c.c = 1;
        Runnable obj= ()->{
          for(int i=0;i<1000;i++){
//              System.out.println(c.c);
              
              c.count();
          }  
        };
        
        Runnable obj2 = ()->{
            for(int i=0;i<1000;i++){
//                System.out.println(c.c);
                c.count();
            }
        };
        
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj2);
        
        t1.start();
        t2.start();
        
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(RaceCondition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(c.c);
        
    }
   
}
