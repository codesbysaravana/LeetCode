import java.util.*;

class day85 {
	public static String RemoveAdjacentDupsII(String s, int k) {
		Stack<int[]> stack = new Stack<>();

		for(char ch : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek()[0] == ch) {
				stack.peek()[1]++;

				if(stack.peek()[1] == k) {
					stack.pop();
				}
			}
			
			else {
				stack.push(new int[]{ch, 1});
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int[] arr : stack) {
			char c = (char) arr[0];
			int count = arr[1];
			for(int i=0; i<count; i++) {
				sb.append(c);
			}
		}

		sb.toString();
	}
}


//to Remember:
	//	use Stack<int[]> array and store like as a pair say the array looks like
	// Stack ---> arr['a', 1]; arr['b', '2'];
	// its storing the pairs as frequency kind of like a map!;

	//final else {add a new 'ch' if its not in stack<int[]> } add new int[]{ch, 1}
	//check if ch already present in stack<int[]>
		//if so update count of it 
		//if count == k; then pop it off