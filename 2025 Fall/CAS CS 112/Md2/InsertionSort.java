package Md2;

public class InsertionSort{

    public static void insertion(int[] a){
        int n = a.length;

        for (int i = 0; i<n;i++){
            int key = a[i];

            int j = i-1;

            while(j>=0 && a[j]>key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
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
        insertion(arr);

        System.out.println(toString(arr));
    }



}