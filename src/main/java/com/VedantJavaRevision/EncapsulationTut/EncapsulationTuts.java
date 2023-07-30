package com.VedantJavaRevision.EncapsulationTut;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

class Human{
    private String name;
    private int age;
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}
public class EncapsulationTuts {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setName("Vedant");
        obj.setAge(22);
        
        System.out.println("name "+obj.getName()+" age "+obj.getAge());
    }
}
