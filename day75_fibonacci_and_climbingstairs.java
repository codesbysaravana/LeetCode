class day75_fibonacci_and_climbingstairs {
    public static int clmibingstairs(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1; //0 for fib
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[n] = dp[n-1] + dp[n-2]; 
        }

        return dp[n];
    }
}