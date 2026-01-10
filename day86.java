import java.util.*;

class day86 {
	public static boolean 132pattern(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int mid = Integer.MIN_VALUE;

		for(int i = nums.length - 1; i>=0; i--) {
			if(nums[i] < mid) {
				return true; // the small (1);
			}

			while(!stack.isEmpty() && nums[i] > stack.peek()) {
				mid = stack.pop(); // the mid (2);
			}

			stack.push(nums[i]); //the peak (3)
		}

		return false;
	}
}


// Small < Biggest > Smaller
// 1	<	3	>	2

//	Loop Traverse right -> left, becuz we need future values 


//int mid = Integer.MIN_VALUE;
//  why? --> if nums[i] > mid 
//  make mid = nums[i]
/* 
Stack stores future peaks (3) -----------------> stack.push(nums[i]);
mid stores the best valley (2) ----------------> mid = stack.pop();      // when new peak comes mid is smaller
current element tries to be the small (1) -----> nums[i] //small

 */