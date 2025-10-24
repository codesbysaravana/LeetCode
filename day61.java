import java.util.*;

class Brute {
    public int BRUTEtotalFruit(int[] fruits) {
        int maxfruits = 0;
        int n = fruits.length;

        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            int count = 0;

            for(int j=i; j<n; j++) {
                set.add(fruits[j]);
                if(set.size() > 2) {
                    break;
                }
                count++;
            }

            maxfruits = Math.max(maxfruits, count);
        }

        return maxfruits;
    }
}

class Main {
    public static void main(String[] args) {
        Brute obj = new Brute();
        int[] fruits = {1,2,3};
        int result = obj.BRUTEtotalFruit(fruits);
    }
}
