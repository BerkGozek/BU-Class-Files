package PS2;
/*
 * Methods6.java
 * 
 * Code added by: name and email
 *
 * Practice with static methods, part I
 */

public class Methods6 {
    /*
     * 0) printVertical - takes a string s and prints the characters of 
     *    the string vertically -- with one character per line.
     */
    public static void printVertical(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
    
    public static void printEveryOther(String s){
        for(int i =0; i<s.length();i++){
            if(i%2==0)
                System.out.print(s.substring(i, i+1));
        }        
    }
    
    public static int longerLen(String a, String b){
        return (a.length()>b.length()?a.length():b.length());
    }

    public static int secondIndex(String a,char b){
        int app = 0;
        int pos = -1;
        for (int i = 0;i<a.length() && app<2;i++){
            if(a.charAt(i)==b){
                pos = i;
                app++;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        /* Sample test call */
        printVertical("method");        

    }
}