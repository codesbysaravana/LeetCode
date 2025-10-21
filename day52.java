import java.util.*;


class Student {
    int rno;
    String name;
    float marks;

    Student(int rno, String name, float marks) {
        this.name = name;
        this.rno = rno;
        this.marks = marks;
    }
}

//remeber checking the frecking indices
class day52 {
    public static int[] bruteforce(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n]; // result array to store days until warmer temp
        //int count = 0; // not needed for logic, just counting comparisons if you want
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    arr[i] = j - i; // found a warmer day
                    break; // stop checking further days
                }
            //    count++; // counts number of failed comparisons
            }
        }
        return arr;
    }

    public static int[] dailyTemp(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[i]>temp[stack.peek()]) {
                int dex = stack.pop();
                res[dex] = i - dex;
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temp = new int[n];
        for(int i=0; i<n; i++) {
            temp[i] = sc.nextInt();
        }

        int[] res = bruteforce(temp);
        System.out.println(res);

        sc.close();

        //Student s1 = new Student(102, "Saravana", 92.0f);

    }
}