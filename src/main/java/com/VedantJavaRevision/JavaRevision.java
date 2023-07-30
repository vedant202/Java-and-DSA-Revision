/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.VedantJavaRevision;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class JavaRevision {

    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        System.out.println("Hello world1");
        
        Scanner sc = new Scanner(System.in);
//        int inp = sc.nextInt();
        String str = sc.nextLine();
        
        System.out.println("Input String "+str);
        
        char[] charArr = str.toCharArray();
        int n = charArr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(charArr[i]>charArr[j]){
                    char temp = charArr[i];
                    charArr[i] = charArr[j];
                    charArr[j] = temp;
                }
                System.out.println(charArr);
            }
        }
        
        System.out.println(charArr);
        
    }
}
