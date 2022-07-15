package com.sandun;
import java.util.*;

public class LinkedListPalindrome {

    public static boolean isEqual(LinkedList lList1,LinkedList lList2,int n){
        boolean a = true;
        for(int i=0; i<n; i++){
            if(lList1.get(i) != lList2.get(i)){
                a = false;
                break;
            }
        }
        return a;
    }


    public static void main(String args[]){
        LinkedList<String> lList1 = new LinkedList<String>();
        LinkedList<String> lList2 = new LinkedList<String>();

        lList1.add("R");
        lList1.add("A");
        lList1.add("C");
        lList1.add("E");
        lList1.add("C");
        lList1.add("A");
        lList1.add("R");

        System.out.println("Linked List is: "+lList1);

        lList2 = (LinkedList) lList1.clone(); // clone the linked list


        // Reverse the cloned LinkedList
        for(int i=0; i<lList2.size()-1; i++){
            for(int j=0; j<lList2.size()-i-1; j++){
                String x = lList2.get(j);
                String y = lList2.get(j+1);
                lList2.set(j,y);
                lList2.set(j+1,x);
            }
        }
        System.out.println("Reversed Linked List is: "+lList2);

        if(isEqual(lList1,lList2,lList2.size())==true){ // Check whether Linked List and Reverserd Linked are equal or not
            System.out.println("The Linked List is a Palindrome");
        }else{
            System.out.println("The Linked List is not a Palindrome");
        }
    }

}
