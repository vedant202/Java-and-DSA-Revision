/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolymorphismTuts;

/**
 *
 * @author DELL
 */

class Calc{
    public int add(int a,int b){
        return a+b;
    }
}

class AdvaCalc extends Calc{
    public int add(int a,int b){
        return a+b+2;
    }
}

public class OverridingTuts {
    public static void main(String[] args) {
        AdvaCalc calc = new AdvaCalc();
        int res = calc.add(5, 5);
        System.out.println(res);
    }
}
