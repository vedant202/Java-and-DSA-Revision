/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts;

/**
 *
 * @author DELL
 */
public class MatrixPaths {
    public static int matrixPaths(int n, int m){
        if(n==1 || m==1) return 1;
        
        return matrixPaths(n-1, m)+matrixPaths(n, m-1);
    }
    public static void main(String[] args) {
        int n=3;
        int m=2;
        int paths = matrixPaths(n, m);
        System.out.println("Paths "+paths);
    }
}
