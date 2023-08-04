package com.VedantJavaRevision.FileHandlingJava;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class FileTuts1 {
    public static void main(String[] args) {
        //Cpde to createnew file
        File myFile = new File("./MyFile1.txt");
        
        
        //FileWritter to write to file
        FileWriter fileWrite;
        
        try{
            // Checking if file exists
            if(!myFile.exists()){
                // for creating a file
                myFile.createNewFile();
                
                //COde to write to a file
                fileWrite = new FileWriter("./MyFile1.txt");
                fileWrite.write("This is my first file\n ok byeee");
                fileWrite.close();
                
                
            }else{
                // Code for reading content from file
                Scanner sc = new Scanner(myFile);
                
                while(sc.hasNextLine()){
                    String line =sc.nextLine();
                    System.out.println(line);
                    
                   
                }
                sc.close();
                
            }
        }catch(IOException exception){
            System.out.println("Unable to create file");
            exception.printStackTrace();
        }
        
        
        
    }
}
