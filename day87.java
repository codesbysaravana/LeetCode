// SELECTION SORT
public class Day87 {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {   // We need n-1 passes

            int min = i;                        // assume current index has minimum
            for (int j = i + 1; j < n; j++) {   // find minimum element in unsorted part
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];        // swap only if min is different
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}


/* 
Outer loop → "Which position am I fixing?"
Inner loop → "Who is the smallest from here onward?"
Swap → "Put smallest in correct place"

 */