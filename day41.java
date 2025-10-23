import java.util.*;

class Solution {
    public static int[] nextGreaterEle(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // initialize result array with -1 (default if no greater element found)

        // Outer loop: for each element nums[i]
        for (int i = 0; i < n; i++) {
            // Inner loop: check the next (n-1) elements in circular manner
            for (int j = 1; j < n; j++) {
                // Calculate the circular index
                int nextIndex = (i + j) % n;
                
                // If we find a greater element, store it and break
                if (nums[nextIndex] > nums[i]) {
                    result[i] = nums[nextIndex];
                    break; // stop at the first greater element
                }
            }
        }

        return result;
    }

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < 2*n; i++) {
            int index = i % n;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int popped = stack.pop();
                res[popped] = nums[index];
            }
            if(i<n) {
                stack.push(index);
            }
            
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] res = nextGreaterEle(nums);
        System.out.println(Arrays.toString(res));

        sc.close();
    }
}
