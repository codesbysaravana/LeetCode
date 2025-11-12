import java.util.Scanner;

class Day67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of heights: ");
        int h = sc.nextInt();

        int height[] = new int[h];
        System.out.println("Enter the heights:");
        for (int i = 0; i < h; i++) {
            height[i] = sc.nextInt();
        }

        int res = Water.containsMostWater(height);
        System.out.println("Maximum area of water: " + res);

        sc.close();
    }
}

class Water {
    public static int containsMostWater(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            // calculate the area
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            int area = width * h;

            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the smaller height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
