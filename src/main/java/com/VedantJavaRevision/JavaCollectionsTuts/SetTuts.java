/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VedantJavaRevision.JavaCollectionsTuts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author DELL
 */

public class SetTuts {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(50);
        set.add(1);
        set.add(2);
        set.add(13);
        set.add(1);
        
        
        System.out.println(set);
        
        set = null;
        
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(13);
        treeSet.add(1);
        
//        System.out.println(treeSet);
        
        Iterator iter = treeSet.iterator();
        
        while(iter.hasNext()){
            System.out.print(iter.next());
        }
        
    }
}
