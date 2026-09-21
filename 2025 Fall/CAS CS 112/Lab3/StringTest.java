package Lab3;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Boston";//Q2
        String s2 = "University";//Q2
        System.out.println( s1.substring(3, 6) );//Q3
        System.out.println( s2.substring(0, 3) );//Q4.a
        System.out.println( s2.toUpperCase().substring(0, 3) );//Q4.b
        System.out.println( s2.substring(3,4));//Q4.c
        System.out.println(
            s1.toUpperCase()
            .substring(2)+
            s2.toUpperCase()
            .substring(4,5));//Q4.b        


    }
    
    public static String replaceStart(String str1, String str2){
        if(str1.length()<str2.length())
            return str1+str2.substring(str1.length());
        else
            return str1;
    }//Q5
    /*
     * Q6
     * The replaceString method has to be called within a 
     *      println method because it is made to return a
     *      string rather than print a line.
     */
}
