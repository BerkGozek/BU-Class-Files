package Lab7;

public class Fibonacci {
    //old method:
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int prev1 = fib(n - 2);
            int prev2 = fib(n - 1);
            return prev1 + prev2;
        }
    }
    /*
     *  fib(4) [call 1]
     *  ├── fib(2) [call 2]
     *  │   ├── fib(0) [call 3]
     *  │   └── fib(1) [call 4]
     *  └── fib(3) [call 5]
     *      ├── fib(1) [call 6]
     *      └── fib(2) [call 7]
     *          ├── fib(0) [call 8]
     *          └── fib(1) [call 9]
     */
/*
     *  | Return order | Call # | Call expression        | Return value |
     *  | :----------- | :----- | :--------------------- | :----------- |
     *  | 1            | 3      | fib(0)                 | 1            |
     *  | 2            | 4      | fib(1)                 | 1            |
     *  | 3            | 2      | fib(2) = fib(0)+fib(1) | 2            |
     *  | 4            | 6      | fib(1)                 | 1            |
     *  | 5            | 8      | fib(0)                 | 1            |
     *  | 6            | 9      | fib(1)                 | 1            |
     *  | 7            | 7      | fib(2) = fib(0)+fib(1) | 2            |
     *  | 8            | 5      | fib(3) = fib(1)+fib(2) | 3            |
     *  | 9            | 1      | fib(4) = fib(2)+fib(3) | 5            |
 */
 

 //new method
    public static int newFib(int n) {
        int result = 1;  // base case value

        if (!(n == 0 || n == 1)) {
            int prev1 = fib(n - 2);
            int prev2 = fib(n - 1);
            result = prev1 + prev2;
        }

        return result;
    }

}
