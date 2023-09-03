/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.RecurssionTuts.Backtracking;

/**
 *
 * @author DELL
 */
public class sudokuSolver {
    public static boolean check(int[][] grid,int no,int row,int col){
        int r = row;
        int c= col;
        
        // checking col;
        for(int i=0;i<grid.length;i++){
            if(grid[i][c] == no){
                return false;
            }
        }
        //checking row
        for(int i=0;i<grid.length;i++){
            if(grid[row][i] == no){
                return false;
            }
        }
        
        //checking grid
        int grid_row = r%3; 
        int grid_col = c%3;
        
        int grid_row_start = r-grid_row;
        int grid_col_start = c-grid_col;
       
        
        for(int i=grid_row_start;i<grid_row_start+3;i++){
            for(int j=grid_col_start;j<grid_col_start+3;j++){
                if(grid[i][j]==no){
                    return false;
                }
            }
        }
        
        return true;
    }
    public static boolean solveSudoku(int[][] grid,int n){
        int r=-1;
        int c=-1;
        
        boolean isEmpty = false;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                    isEmpty = true;
                    r =i;
                    c=j;
                    break;
                }
            }
            if(isEmpty){
                break;
            }
        }
        if(!isEmpty){
            return true;
        }
        
        for(int num=1;num<10;num++){
            if(check(grid, num, r,c)){
                grid[r][c] = num;
                if(solveSudoku(grid, n)){
                    return true;
                }
                grid[r][c] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        int n= grid.length;
        solveSudoku(grid,grid.length);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
