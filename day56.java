import java.util.HashSet;
import java.util.Scanner;

class day56 {
    //sliding window
    public static int Longestsubstringwithoutrepeating(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(c);
            maxLen = Math.max(maxLen, right - left+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int result = Longestsubstringwithoutrepeating(s);
        System.out.print(result);
        sc.close();
    }
}
