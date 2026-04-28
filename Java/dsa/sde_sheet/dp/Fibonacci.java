package dsa.sde_sheet.dp;

public class Fibonacci {

    static int fib(int n, int [] dp){
        if(n <= 1)
            return  n;
        if(dp[n]!=-1)
            return dp[n];

        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }

    static void main() {

        int n = 8,i=0;
        int [] dp = new int[n+1];
        while(i<=n)
            dp[i++]=-1;

        System.out.println(n+"th number in fib series: "+fib(n, dp));


    }
}
