import java.util.*;

class day48 {
    public static int[][] brute(int[][] mergethis) {
        return new int[0][0];
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int mergethis[][] = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mergethis[i][j] = sc.nextInt();
            }
        }

        int result[][] = brute(mergethis);
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j]);
            }   
            System.out.println();
        }

        sc.close();
    }
}