import java.util.Scanner;
import java.util.Stack;

class day54 {
    public static String PathosVerdes(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue;
            }

            else if(part.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() > 0? sb.toString() : "/";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        String resultPath = PathosVerdes(path);
        System.out.println(resultPath);
        sc.close();
    }
}
