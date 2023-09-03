/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problemes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DELL
 */

public class EmployeeArraylist {
    class Employee{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" + "name=" + name + ", age=" + age + '}';
        }
        
        
    }
    
    class a extends Thread{

        @Override
        public void run() {
            super.run(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
        
    }
    public static void main(String[] args) {
        EmployeeArraylist employeClass = new EmployeeArraylist();
        EmployeeArraylist.Employee e1 = employeClass.new Employee("vedant",22);
        EmployeeArraylist.Employee e2 = employeClass.new Employee("aryan",16);
        EmployeeArraylist.Employee e3 = employeClass.new Employee("sameer",38);
        


        System.out.println(e1.age);
        
        
        ArrayList<EmployeeArraylist.Employee> arr = new ArrayList<>();
        arr.add(e1);
        arr.add(e2);
        arr.add(e3);
        
        List<EmployeeArraylist.Employee> result = arr.stream().filter((i)->{
          return i.getAge()<30;
        }).collect(Collectors.toList());
        
        
        result.stream().forEach((i)->{
            System.out.println(i);
        });
        
        
    }
}
