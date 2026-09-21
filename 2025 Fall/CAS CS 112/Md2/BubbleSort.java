package Md2;

public class BubbleSort{

    public static void bubble(int[] a){

        boolean swapped;
        int length = a.length;

        for(int i = 0; i<length-1; i++){
            swapped = false;

            for(int j = 0; j<length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }


    }
    public static String toString(int[] a){
        String retval = "[";
        for(int i : a){
            retval +=i+" ";
        }
        retval+="]";
        return retval;
    }

    public static void main(String args[]){
        int[] arr = {5,6,8,2,3,1};
        bubble(arr);
        System.out.println(toString(arr));
    }

}