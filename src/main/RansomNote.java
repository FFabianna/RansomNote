package main;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class RansomNote {
	
	private static Hashtable<String,Integer> magazineHashtable = new Hashtable<String,Integer>();

    public static void checkMagazine(List<String> magazine, List<String> note) {
        
        String a="Yes";
        Integer amount=0;
        for(Integer i=0;i<magazine.size();i++) {
            amount=0;
            if(magazineHashtable.containsKey(magazine.get(i))) {
                amount=magazineHashtable.get(magazine.get(i));
                magazineHashtable.put(magazine.get(i),amount-1);
            }
            if(!magazineHashtable.containsKey(magazine.get(i))){
                magazineHashtable.put(magazine.get(i),0);
            }
        }
        if(magazine.size() >= note.size()){
             String w="";
             for(Integer i=0;i<note.size();i++) {
                 amount=0;
                 w=note.get(i);
                 if(magazineHashtable.containsKey(w)) {
                     amount=magazineHashtable.get(w);
                     magazineHashtable.put(w,amount+1);
                     if(magazineHashtable.get(w)>1) {
                         a="No";
                         System.out.println(a); 
                         return;
                     }
                 }else if(!magazineHashtable.containsKey(w)) {
                     a="No";
                     System.out.println(a); 
                     return;
                 }
             } 
        }else {
            a="No";
            System.out.println(a); 
            return;
        }
        System.out.println(a); 
        return;
    }

    

}



