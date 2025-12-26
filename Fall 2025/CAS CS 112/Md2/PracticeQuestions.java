package Md2;

public class PracticeQuestions {

    /*Q1
    * Write a recursive static method named sumReciprocals 
    * that takes as its only parameter an integer n that you
    * can assume is positive, and that uses recursion (no loops!) 
    * to compute and return a floating-point value that is the sum 
    * of the reciprocals of the integers from 1 to n. 
    * 
    * For example, sumReciprocals(2) should return 1.5, which is 1/1 
    * + 1/2, and sumReciprocals(4) should return approximately 2.0833, 
    * which is 1/1 + 1/2 + 1/3 + 1/4.
    * 
     */
    public static double sumReciprocals(int n) {
        if (n == 1) {
            return 1;
        }

        return sumReciprocals(n - 1) + (1.0 / n);
    }


    /*Q2
    * Write a recursive static method called removePadding() that takes 
    * a string s and that uses recursion to return a new string in which 
    * all leading and trailing spaces have been removed. For example, the 
    * call removePadding("     hello world  ") should return "hello world".
     */
    public static String removePadding(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        if (s.charAt(0) == ' ') {
            return removePadding(s.substring(1));
        }
        if (s.charAt(s.length() - 1) == ' ') {
            return removePadding(s.substring(0, s.length() - 1));
        }
        return s;

    }
    {//Q3
    /*
    * A program for recursive backtracking includes a method similar to this one:
    */
    /* 
    public boolean key_function(int i) {
        if (i > imax) {
            return true;
        }

        for (int alternative = 0; alternative < n; alternative++) {
            if (is_valid(alternative, i)) {
                apply_alt(alternative);
                if (_________________) {    // what goes here?
                    return true;
                }
                remove_alt(alternative);
            }
        }

        return false;
    }
    */
    /*    The blank should be replaced by:
     *a - is_safe(i) - >This one
     *b - apply_alt(alternative + 1)
     *c - key_function(alternative + 1)
     *d - key_function(i)
     *e - key_function(i + 1)
     */
}

    //Q4  - a
    //Q5  - a
    //Q6  - c
    //Q7  - d
    //Q8  - d
    //Q9  - e
    //Q10 - c (how can it do 5000??? sqrt(5000)= not an int???)
    //Q11 - e
    //Q12 - b
    //Q13 - c
    //Q14 - c
    //Q15 - b
    /*Q16
     * a
     *      pivot = 12, result: [12,53,71,36,46,41,23,17]
     * 
     * b
     *      pivot = 17, result: [12,17,71,36,46,41,23,53]
     * 
     * c
     *      result: [17,53,36,46,41,23,12,71]
     * 
     * d
     *      result: [12,17,23,36,46,41,71,53]
     * 
     * e
     * 
     *      result: [17, 36, 46, 53, 71, 41, 23, 12]
     * 
     * f
     *      result: []
     */


    public static void main(String args[]) {
        System.out.println(sumReciprocals(2));

        System.out.println(removePadding("   hello world "));
    }

}
