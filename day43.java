import java.util.Scanner;

class day43 {
    //helper function
    private static int factorial(int n) {
        if(n==0 || n==1) return 1;
        return n*factorial(n-1);
    }

    //brute force
    public static int zeroesBrute(int n) {
        int temp = factorial(n);
        int zeroCount = 0;
        while(temp%10 == 0) {
            zeroCount++;
            temp = temp/10;
        }

        return zeroCount;
    }

    //optimized
    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        //just checking if multiples of 5 
        while(n>0) {
            n = n/5;
            zeroCount = zeroCount+n; 
        }

        return zeroCount;
    }


    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

       // int n = sc.nextInt();

        //brute-force
        //int result = zeroesBrute(n);

        //int result = trailingZeroes(n);
    }
}



/* 
Optimized Logic (the DSA trick):

Ignore computing factorial.
Just count how many multiples of 5 are there in the numbers 1..n.
Each multiple of 5 contributes one factor of 5.
Example: 5, 10, 15, 20 → each gives at least one 5.
But wait, numbers like 25, 125, 625... contribute more than one 5.
Example: 25 = 5 × 5, so it contributes two 5s.
So we must keep dividing by higher powers of 5. */

//REMEMBER ---> a 2x5 => 10 so hence makes it 10!
// to check the 10;