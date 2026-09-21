
import java.util.Scanner;

public class Problem1{
    /*
     * This static method should take an integer x and return:
     *    x * -1 if x is positive
     *    the unchanged value of x otherwise
     */
    public static int makeNeg(int x)
    {
        if (x > 0){
            x *= -1;
        }
        return x;
    }


    public static void main(String args) 
    {   
        Scanner console = new Scanner(System.in);

        System.out.print("Enter an integer x: ");
        int x = console.nextInt();

        System.out.println("makeNeg(x) = "+ makeNeg(x));

        console.close();
    }
}

