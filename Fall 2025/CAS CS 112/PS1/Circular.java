import java.util.Scanner;

public class Circular {
    /*
     * Circular
     * by Berk Gozek (berkgzk@bu.edu)
     * 9/12/2025
     * 
     * 
     * This Program computes the area of a circular piece of land,
     *  based on its diameter.
     * 
     * The input to this program must be an integer.
     * 
     * 
     * 
     */


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);//creates scanner

        System.out.println("Enter the diameter of the land to the nearest foot:");

        int diam = scan.nextInt();//diameter given by to user to the program
        double rad = diam/2.0;//radius to the diameter

        // area of the land in double square feet
        double areaDb = Math.pow(rad, 2)*Math.PI;

        //the area in yards w/o the the remainder
        int areaYrd = ((int)Math.round(areaDb)-(int)Math.round(areaDb)%9)/9;
        
        //remainder of the area in yards
        int areaYrdLft = (int)Math.round(areaDb)%9;

        System.out.println("The area of the circle is approximately:");
        
        // the area is rounded here
        System.out.println((int)Math.round(areaDb)+" square feet"); 

        System.out.println(areaYrd + 
                            " square yards plus " +
                            areaYrdLft +
                            " square feet");

        scan.close();//closes scanner
    }
}
