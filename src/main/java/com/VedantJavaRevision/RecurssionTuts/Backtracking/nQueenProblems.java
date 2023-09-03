/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts.Backtracking;

/**
 *
 * @author DELL
 */
public class nQueenProblems {
    
    public static boolean isSafe(int[][] board,int row,int col){
        int r = row;
        int c = col;
        
        //Checking left up diagonals
        while(r>=0 && c>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        
        //Checking right up diagonals
        while(r>=0 && c<board.length){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c++;
        }
        r = row;
        c = col;
        
        // checking straight left
        while(c>=0 && r>=0){
            if(board[r][c]==1){
                return false;
            }
            c--;
        }
        r = row;
        c = col;
        //checking left down diagonal
        while(r<board.length && c>=0 && r>=0){
            if(board[r][c] == 1){
                return false;
            }
            r++;
            c--;
        }
        r = row;
        c = col;
        
        // checking straight  up
        while(r>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
        }
        return true;
    }
    public static boolean nQueenSol(int[][] board,int n,int row){
        if(row==n){
            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
            System.out.println();
            return true;
        }
        
        for(int col=0;col<n;col++){
            if(isSafe(board, row,col)){
                board[row][col] = 1;
                if(nQueenSol(board, n, row+1)){
                    return true;
                }
//                nQueenSol(board, n, row+1);
                board[row][col] = 0;
            }
            
            
        }
        
        return false;
    }
    public static void main(String[] args) {
        int n=4;
        int [][] board = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        
        nQueenSol(board,n,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
