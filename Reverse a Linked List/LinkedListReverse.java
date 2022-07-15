package com.sandun;
import java.util.*;

public class LinkedListReverse {

    public static void main(String args[]){
        //Create a Linked List using numbers object
        LinkedList<Integer> numbers = new LinkedList<Integer>();

        // Add values to the linked list
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        System.out.println("Linked List is: "+numbers);

        for(int i=0; i<numbers.size()-1; i++){
            for(int j=0; j<numbers.size()-i-1; j++){

                int a = numbers.get(j); // Get the (j)th index position value and store it into a
                int b = numbers.get(j+1);  // Get the (j+1)th index position value and store it into b

                //Swap the (j)th & (j+1)th index position values
                numbers.set(j,b);
                numbers.set(j+1,a);
            }
        }
        System.out.println("Reversed Linked List is: "+numbers);

    }

}
