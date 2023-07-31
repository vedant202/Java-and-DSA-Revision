/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision;

/**
 *
 * @author Vedant
 * 
 * Final keyword can be used whit variable,method, class
 */

final class A{ //Final class can be extendento child class
    public void show(){
        System.out.println("In class A or Complex logic");
    }
}

class Calc{
    final public void show(){ //final method cant be override
        System.out.println("By vedant");
    }
}

class AdvaCalc extends Calc{
    
}
public class FinalKeywordTuts {
    public static void main(String[] args) {
        final int num = 8;
//        num = 3;
        System.out.println(num);
        
        A a = new A();
        a.show();
        
    }
}
