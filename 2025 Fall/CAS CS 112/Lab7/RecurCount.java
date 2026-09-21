package Lab7;
/* 
 * RecurCount - implementing a recursive method for counting 
 * the number of occurrences of an element in an integer array
 */

import java.util.Scanner;

public class RecurCount {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 3, 5 ,2, 7, 6, 4, 4, 4, 4 ,5, 6, 9, 10, 2, 2};

        System.out.println("\nWelcome to the Array Count Test Program!");

        // Reads in one string from the user
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nType in an integer to search for and press enter: ");
        int num = userInput.nextInt();
        userInput.close();

        // Call the recursive function here by replacing true with your call.
        int count = countN(num, arr, 0);

        // Printing out the result
        System.out.println("There were " + count +" "+ num + "(s) in the array");
        
    }

    private static int countN(int n, int[] arr, int index) {
        // Base case: if index has reached the end of the array, return 0
        if (index == arr.length) {
            return 0;
        }

        // Recursive case: check if the current element matches n
        if (arr[index] == n) {
            return 1 + countN(n, arr, index + 1);
        } else {
            return countN(n, arr, index + 1);
        }
    }
}
