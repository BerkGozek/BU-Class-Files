package Lab3;
import java.util.*;

public class ArrayPractice {
    

    public static void main(String[] args) {
            
        int[] a = {2, 4, 6, 8};

        System.out.println(a);

        // What do you expect to see?

        System.out.println(Arrays.toString(a));

        // Now, what do you expect to see?
    }

    public static boolean equals(int[] a1, int[]a2){
        if(a1.length!=a2.length)
            return false;
        for (int i =0; i<a1.length;i++)
            if (a1[i]!=a2[i])
                return false;
        return true;
    }
    public static void Square (int[] a){
        for(int i = 0; i<a.length;i++)
            a[i] *= a[i];
    }
}
