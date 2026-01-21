import java.util.*;

public class day93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Line = sc.nextLine();
        String[] parts = Line.split(" ");
        
        int n = parts.length;
        int count = n;

        for(int i =0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(parts[i].equals(parts[j])) {
                    count++; //if dup appear more time, it increases;
                }
            }
        }

        System.out.print(count);

        sc.close();
    }




















    // OPTIMZED

    public static void Optimized(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        String Line = sc.nextLine();
        String[] parts = Line.split(" ");
        
        int count = parts.length; //each LED is a group

        for(String part : parts) {
            int freq = map.getOrDefault(part, 0); //from map get part if exists or 0 new;
            count = count + freq;
            map.put(part, freq + 1);
        }
        
        System.out.print(count);
        sc.close();
    }
}