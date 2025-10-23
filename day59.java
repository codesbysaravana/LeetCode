//REMEBER FOR FUTURE SARAVANA 
// ONLY USE HASHSET WHEN NO DUPLICATE VALUES

//SLIDING WINDOW (VARIABLE ONE)
import java.util.*;

class day59 {
    public static int MinSizeSubArraySum(int[] nums, int target) {
        int n = nums.length;
        //minimum so
        int minLen = Integer.MAX_VALUE;
        int sum = 0; //curr rolling sum;
        int left = 0;

        for(int right = 0; right<n; right++) {
            sum = sum + nums[right];

            //think if not then what to do--->
            while(sum >= target) {
                minLen = Math.min(minLen, right - left+1);
                sum = sum - nums[left];
                left++;
            }
        }

        //if no change return 0 as default not found
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}




//remember when we want a minimum size of arrays or when porblems like this use
//Math.min(minSum, right-left+1)


//remember we want to increase and match target
//so keep adding when sum is less than target
//  and if sum is greater than or equal to targert find out the vlaues or inside it

/* 
Start with two pointers: left and right at index 0.

Move right forward, adding nums[right] to sum.

Whenever the sum is greater than or equal to target,

Update minLen (this is a valid subarray).

Try to shrink the window from the left (subtract nums[left] and move left++).

Repeat until the end of array. */