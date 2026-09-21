package PS3;
import java.util.Scanner;
/* File: MyArrays
 *
 * Author:  CS112 
 *
 * Purpose: To create a class that allows you to
 * manipulate an array of integers.
 */

import java.util.Arrays;                    

public class MyArray  {

    // the sentinel value used to indicate end of input, initialized to -999
    // the default size of the array if one is not specified, initialized to 10
    // the lower bound of the range of integer elements, initialized to 10
    // the upper bound of the range of integer elements, initialized to 100
    // a data member to reference an array of integers
    // a data member to represent the number of elements entered into the array
    int[] arr;
    int numElements;
    public static final int SENTINEL = -999;
    public static final int DEFAULT_SIZE = 10;
    public static final int LOWER_BOUND = 10;
    public static final int UPPER_BOUND = 100;

    int min, max, sum;
    double average;


    // CONSTRUCTORS
    // Initializes a MyArray object using default members
    public MyArray() {
       arr = new int[DEFAULT_SIZE];
       numElements = 0;
    }

    public MyArray(int n) {
       arr = new int[n];
    }

    public MyArray(int[] inputArr) {
        arr = new int[inputArr.length];      // allocate a new array of same size
        for (int i = 0; i < inputArr.length; i++) {
            arr[i] = inputArr[i];            // copy elements one by one
        }
    }
    public void inputElements() {
        Scanner sc = new Scanner(System.in);

        numElements = 0; // reset each time
        System.out.println("Enter up to " + arr.length +
                           " integers between " + LOWER_BOUND + " and " + UPPER_BOUND +
                           " inclusive. Enter " + SENTINEL + " to end.");

        while (numElements < arr.length) {
            int value = sc.nextInt();

            if (value == SENTINEL) {
                break; // stop early
            }

            if (value >= LOWER_BOUND && value <= UPPER_BOUND) {
                arr[numElements] = value;
                numElements++;
            } else {
                System.out.println("Rejected: " + value +
                                   " (must be between " + LOWER_BOUND + " and " + UPPER_BOUND + ")");
            }
        }
    }
    public static boolean validInput(int num) {
        return num >= 10 && num <= 100;  // or use LOWER_BOUND and UPPER_BOUND
    }


    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, numElements));
    }

    private void computeStatistics() {
    if (numElements == 0) {
        sum = 0;
        min = 0;
        max = 0;
        average = 0.0;
        return;
    }

    sum = 0;
    min = arr[0];
    max = arr[0];

    for (int i = 0; i < numElements; i++) {
        sum += arr[i];
        if (arr[i] < min) min = arr[i];
        if (arr[i] > max) max = arr[i];
    }
    average = (double) sum / numElements;
}

    public int numOccurrences(int value) {
        int count = 0;
        for (int i = 0; i < numElements; i++) {
            if (arr[i] == value) {
                count++;
            }
        }
        return count;
    }

    public boolean insertElement(int value, int index) {
        if (index < 0 || index > numElements) {
            return false;
        }

        if (numElements == arr.length) {
            growArray(DEFAULT_SIZE); // or some growth factor
        }

        for (int i = numElements; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = value;
        numElements++;

        computeStatistics();
        return true;
    }

    public boolean removeElement(int index) {
        if (index < 0 || index >= numElements) {
            return false;
        }

        for (int i = index; i < numElements - 1; i++) {
            arr[i] = arr[i + 1];
        }
        numElements--;

        computeStatistics();
        return true;
    }

    public boolean growArray(int n) {
        if (n <= 0) {
            return false;  // can't grow by zero or negative
        }

        int[] newArr = new int[arr.length + n];

        for (int i = 0; i < numElements; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;

        return true;
    }
    public int getSum() {
        return sum;   
    }

    public int getMin() {
        return min;   
    }

    public int getMax() {
        return max;   
    }

    public double getAvg() {
        return average;  
    }

    public int[] getArr() {
        return arr;   // returns the entire array
    }

    public int replace(int val1, int val2) {
        // check if val2 is outside bounds
        if (val2 < LOWER_BOUND || val2 > UPPER_BOUND) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val1) {
                arr[i] = val2;
                count++;
            }
        }
        return count;
    }

    public static void main(String [] args) {

            System.out.println("\nUnit Test for MyArray.\n");

        // Fill in your unit tests

        
    }
}

