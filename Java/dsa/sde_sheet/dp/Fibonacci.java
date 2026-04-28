package dsa.sde_sheet.dp;

public class Fibonacci {

    // Time Complexiy: O(n)
    // Space Complexity: O(n)
    static int fibMem(int n, int [] dp){
        if(n <= 1)
            return  n;
        if(dp[n]!=-1)
            return dp[n];

        dp[n] = fibMem(n-1, dp) + fibMem(n-2, dp);
        return dp[n];
    }

    // Time Complexiy: O(n)
    // Space Complexity: O(n)
    static int fibTab(int n){
        int []dp = new int[n+1];

        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    // Time Complexiy: O(n)
    // Space Complexity: O(1)
    static  int fibOpt(int n){
        int prev1 =1, prev2=0;

        for(int i=2; i<=n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1=curr;
        }

        return prev1;
    }

    static void main() {

        int n = 12,i=0;
        int [] dp = new int[n+1];
        while(i<=n)
            dp[i++]=-1;

        System.out.println(n+"th number in fib series by Memoization: "+fibMem(n, dp));
        System.out.println(n+"th number in fib series by Tabuaization: "+fibTab(n));
        System.out.println(n+"th number in fib series by Optimization: "+fibOpt(n));


    }
}
