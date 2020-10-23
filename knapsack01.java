// "static void main" must be defined in a public class.
public class Main 
{
    public static void main(String[] args) {
        int[] p= new int[] { 20, 5, 40, 40, 15, 25 };
        int[] w= new int[] {  1, 2,  8,  8,  7, 4 };
        int[][] dp = new int[p.length][p.length];
        for(int i=0; i<p.length; i++) Arrays.fill(dp[i],-1);
        System.out.println(knapsackMemo(p,p.length-1,w,10));
        System.out.println(knapsackDp(p,w,10));
        //for(int i=0; i<p.length; i++)System.out.println(Arrays.toString(dp[i]));
    }
    
    private static int knapsackMemo(int[] v, int n, int[] w, int W)
    {
        if(W<0) return Integer.MIN_VALUE;
        if(n < 0 || W == 0) return 0;
        int include = v[n] + knapsackMemo(v, n-1, w, W-w[n]);
        int exclude = knapsackMemo(v, n-1, w, W);
        return Math.max(include,exclude);
    }
    
    private static int knapsackDp(int[] v, int[] w, int W)
    {
        int[][] dp = new int[v.length+1][W+1];
        for(int i=1; i<=v.length; i++)
        {
            for(int j=0; j<=W; j++)
            {
                if(w[i-1]>j) 
                    dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }
        return dp[v.length][W];
    }
}
