/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.abstractionTuts;

/**
 *
 * @author DELL
 */

abstract class Parent{
    public Parent(){
        System.out.println("Parent ka constructor hoon main");
    }
    abstract void greet();
    
}

class Child extends Parent{
    public Child(){
        System.out.println("Child Constructor hoon main");
    }
    
    @Override
    void greet(){
        System.out.println("Good Morning");
    }
}

public class AbstractTuts {
    public static void main(String[] args) {
        Child c = new Child();
        c.greet();
    }
}
