/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListsQuestions;

/**
 *
 * @author DELL
 */
public class findElement2DMatrix {
    static int binarySarchRow(int[] arr,int ele,int s,int n){
        int mid = (s+n)/2;
//        System.out.println("mid "+mid);
        if(s>n){
            return -1;
        }
        
        if(arr[mid] == ele){
            System.out.println("ele mid "+mid);
            
            return mid;
        }
        else if(arr[mid]<ele){
            s = mid+1;
            return binarySarchRow(arr, ele, s, n);
        }
        else if(arr[mid]>ele){
            n = mid-1;
            return binarySarchRow(arr, ele, s, n);
        }
        
        return -1;
    } 
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12}};
        int ele = 11;
        
//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat[0].length;j++){
//                if(mat[i][j]==ele){
//                    System.out.println("Element found at pos "+ i+" "+ j);
//                }
//            }
//        }

//          for(int i=0;i<mat.length;i++){
//              int pos = binarySarchRow(mat[i], ele,0,mat[i].length-1);
////              System.out.println("Pos "+pos);
//              if(pos==-1){
//                  System.out.println("Element not found");
//              }
//              else{
//                  System.out.println("Element found at pos "+ i+" "+ pos);
//              }
//              
//          }
            int i = 0;
            int j= mat[0].length-1;
            while(i>=0 && j<mat[0].length){
                System.out.println("element "+mat[i][j]);
                if(mat[i][j] == ele ){
                    System.out.println("Element found at pos "+ i+" "+ j);
                    break;
                } 
                else if(ele>mat[i][j]) i++;
                else if(ele<mat[i][j]) j--;
            }
    }
}
