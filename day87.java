// SELECTION SORT
public class Day87 {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // We need n-1 passes
        for (int i = 0; i < n - 1; i++) {

            int min = i; // assume current index has minimum

            // find minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // swap only if min is different
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
