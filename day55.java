import java.util.*;

class day55 {
    public static String BreakApalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }

        //frst half of palindrome switch to a check nearest a
        char[] chars = palindrome.toCharArray();
        for(int i=0; i<chars.length / 2; i++) {
            if(chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        //if no a is present 
        chars[chars.length -1] = 'b';
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palindrome = sc.next();
        String res = BreakApalindrome(palindrome);
        
        System.out.println(res);
        sc.close();
    }
}