/*
 * InsulinDosage.java
 * 
 * This program computes the dosage of insulin that a person should
 * take before a meal, based on the person's current blood sugar, 
 * their target blood sugar, the amount of exercise they have performed
 * recently, and two characteristics of the meal they are about to consume.
 * 
 * CS 112 Course Staff (cs112-staff@cs.bu.edu)
 * 
 * completed by: your name and email
 * partner (if any): 
 */

import java.util.*;

public class InsulinDosage {
    public static void main(String[] args) {
        // Create a Scanner that can read from the console.
        Scanner scan = new Scanner(System.in);
        
        /*
         * TO DO: replace each of the 0s below with a method
         * call that gets an integer from the user.
         * You MUST use the Scanner object created above
         * at the start of main. You may NOT construct an
         * additional Scanner object.
         */
        System.out.print("current blood sugar: ");
        int currentSugar = scan.nextInt();
        System.out.print("target blood sugar: ");
        int targetSugar = scan.nextInt();
        System.out.print("carbohydrate equivalency: ");
        int carbEquiv = scan.nextInt();
        System.out.print("carbohydrates to consume: ");
        int carbConsume = scan.nextInt();
        System.out.print("amount of exercise (0-3): ");
        int exercise = scan.nextInt();
        
        /*
         * TO DO: complete the rest of the program below.
         */
        Double reccDosage = (currentSugar-targetSugar)/55.0 + (carbConsume*1.0)/carbEquiv -exercise;
        if(reccDosage.doubleValue() == 1)
            System.out.println("Reccomended Dosage: 1 unit");
        else
            if(reccDosage.intValue()==reccDosage.doubleValue())
                System.out.printf("Reccomended Dosage: %d units",reccDosage.intValue());
            else
                System.out.printf("Reccomended Dosage: %f units",reccDosage.doubleValue());
        // Leave this line unchanged.
        scan.close();
    }
}
