package Md2;

public class SelectionSort {
    public static void selection(int[] a){
        int n = a.length;

        for (int i = 0; i<n-1;i++){
            int minLoc = i;
            for (int j = i+1; j<n;j++){

                if(a[j]<a[minLoc]){
                    minLoc = j;
                }

            }

            int temp = a[i];
            a[i]=a[minLoc];
            a[minLoc] = temp;
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
        selection(arr);
        System.out.println(toString(arr));
    }
}
