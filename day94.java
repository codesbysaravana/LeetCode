import java.util.*;

//ROTATION OF ARRAY
public class day94 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}

		int k= sc.nextInt();


		//LOGIC
		for(int r=0; r<k; r++) { //no. of rotations
			int last = nums[n-1];

			for(int i=n-1; i>1; i--) {
				nums[i] = nums[i-1];
			}

			nums[1] = last;
		}

		//print nums;

		sc.close();
	}
}





















class Optimzied {

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int len = N - 1;          // subarray length
        K = K % len;              // optimization

        if (K > 0) {
            reverse(arr, 1, N - 1);      // step 1
            reverse(arr, 1, K);          // step 2
            reverse(arr, K + 1, N - 1);  // step 3
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }

	}
}





