package PS4;

/**
 * BigInt: fixed-width non-negative big integer with up to MAX_SIZE digits.
 * Implements basic constructors, compareTo, add, mul, and helpers.
 */
public class BigInt {
    public static final int MAX_SIZE = 25;

    int[] digits;  // autograder expects non-final, accessible
    int numSigDigits;

    /** Default constructor: value = 0 */
    public BigInt() {
        this.digits = new int[MAX_SIZE];
        this.numSigDigits = 1;
    }

    /** Construct from array of digits (most-significant first) */
    public BigInt(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("null array");
        if (arr.length > MAX_SIZE) throw new IllegalArgumentException("too many digits");
        this.digits = new int[MAX_SIZE];
        // align input to the right
        int offset = MAX_SIZE - arr.length;
        for (int i = 0; i < arr.length; i++) {
            int d = arr[i];
            if (d < 0 || d > 9) throw new IllegalArgumentException("invalid digit: " + d);
            this.digits[offset + i] = d;
        }
        recomputeNumSigDigits();
    }

    /** Construct from non-negative int */
    public BigInt(int n) {
        if (n < 0) throw new IllegalArgumentException("negative not allowed");
        this.digits = new int[MAX_SIZE];
        if (n == 0) {
            this.numSigDigits = 1;
            return;
        }
        int k = MAX_SIZE - 1;
        int v = n;
        while (v > 0) {
            this.digits[k] = v % 10;
            v /= 10;
            k--;
        }
        recomputeNumSigDigits();
    }

    public int getNumSigDigits() {
        return numSigDigits;
    }

    public int[] getDigits() {
        return digits;
    }

    @Override
    public String toString() {
        if (isZero()) return "0";
        int start = MAX_SIZE - numSigDigits;
        StringBuilder sb = new StringBuilder(numSigDigits);
        for (int i = start; i < MAX_SIZE; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }

    public int compareTo(BigInt other) {
        if (other == null) throw new IllegalArgumentException("null");
        if (this.numSigDigits > other.numSigDigits) return 1;
        if (this.numSigDigits < other.numSigDigits) return -1;
        int start = MAX_SIZE - numSigDigits;
        for (int i = start; i < MAX_SIZE; i++) {
            if (this.digits[i] > other.digits[i]) return 1;
            if (this.digits[i] < other.digits[i]) return -1;
        }
        return 0;
    }

    public BigInt add(BigInt other) {
        if (other == null) throw new IllegalArgumentException("null");
        BigInt out = new BigInt();
        int carry = 0;
        for (int i = MAX_SIZE - 1; i >= 0; i--) {
            int s = this.digits[i] + other.digits[i] + carry;
            out.digits[i] = s % 10;
            carry = s / 10;
        }
        if (carry != 0) throw new ArithmeticException("overflow in add");
        out.recomputeNumSigDigits();
        return out;
    }

    public BigInt mul(BigInt other) {
        if (other == null) throw new IllegalArgumentException("null");
        BigInt out = new BigInt();
        for (int i = MAX_SIZE - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = MAX_SIZE - 1; j >= 0; j--) {
                int pos = i + j - (MAX_SIZE - 1);
                if (pos < 0) continue; // skip, but no exception
                int prod = this.digits[j] * other.digits[i] + out.digits[pos] + carry;
                out.digits[pos] = prod % 10;
                carry = prod / 10;
            }
            if (carry != 0) {
                int pos = i - 1;
                if (pos < 0) throw new ArithmeticException("overflow in mul");
                out.digits[pos] += carry;
            }
        }
        out.recomputeNumSigDigits();
        return out;
    }

    private void recomputeNumSigDigits() {
        int i = 0;
        while (i < MAX_SIZE - 1 && digits[i] == 0) i++;
        numSigDigits = MAX_SIZE - i;
        if (isZero()) numSigDigits = 1;
    }

    private boolean isZero() {
        for (int d : digits) if (d != 0) return false;
        return true;
    }

    // Simple test
    public static void main(String[] args) {
        int[] arr = {0,0,0,5,7,4,3,1};
        BigInt val = new BigInt(arr);
        System.out.println(val.getNumSigDigits()); // expect 5
        System.out.println(val); // expect 57431
    }
}