/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolymorphismTuts;

/**
 *
 * @author DELL
 */

class A{
        
        public void show(){
            System.out.println("In A Show");
        }
    }
    
class B extends A{
    public void show(){
        System.out.println("In B Show");
    }
    
}

class C extends A{
    public void show(){
        System.out.println("In c show");
    }
}
public class DynamiMethodDispatch {
    
    
    
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
        
        obj = new B();
        obj.show();
        
        obj = new C();
        obj.show();
        
    }
}
