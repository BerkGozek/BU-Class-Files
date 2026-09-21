package PS2;

public class FunArray {
    public static int firstX(int[] a,int b){
        int pos=-1;
        for(int i=0;i<a.length;i++)
            if (a[i]==b){
                pos=i;break;
            }
        return pos;
    }

    public static void histogram(int[] a){
        for(int i =0;i<a.length;i++){
            for(int ii=0;ii<a[i];ii++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static int[] reverse(int[]a){
        int[] revArr= new int[a.length];

        for(int i = 0; i<a.length;i++)
            revArr[i] = a[a.length-1-i];
        return revArr;
    }
    public static int[] interleave(int[] a, int[]b){
        int[] intrlvedArr = new int[a.length+b.length];
        int loopLength = ((a.length<b.length)? a.length:b.length);

        int posInFinArr = 0;
        for (int i = 0;i<loopLength;i++){
            intrlvedArr[posInFinArr] = a[i];
            posInFinArr++;
            intrlvedArr[posInFinArr] = b[i];
            posInFinArr++;
        }
        if(a.length!=b.length){
            if(a.length>b.length){
                for(int i = (b.length);i<a.length;i++){
                    intrlvedArr[posInFinArr] = a[i];
                    posInFinArr++;
                }
            }
            else{
                for(int i = (a.length);i<b.length;i++){
                    intrlvedArr[posInFinArr] = b[i];
                    posInFinArr++;
                }
            }
        }
        return intrlvedArr;
    }

    public static void main(String[] args) {


    }
}
