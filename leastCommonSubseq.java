// "static void main" must be defined in a public class.
public class Main 
{
    public static void main(String[] args) {
        int[] p= new int[] { 20, 5, 40, 40, 15, 25 };
        int[] w= new int[] {  1, 2,  8,  8,  7, 4 };
        String s1 = "Harshal";
        String s2 = "ashmanlo";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length(); i++) Arrays.fill(dp[i],-1);
        int i=s1.length()-1; int j=s2.length()-1; int len =0;
        System.out.println(lcsMemo(s1,s2, i, j , len, dp));
        System.out.println(lcsDP(s1,s2, i, j , len, dp));
        //for(int i=0; i<p.length; i++)System.out.println(Arrays.toString(dp[i]));
    }
    
    private static int lcsMemo(String s1, String s2, int i, int j, int len, int[][] dp)
    {
        if(dp[i][j] != -1) return dp[i][j];
        if(i<=0 || j <=0) return 0;
        if(s1.charAt(i) == s2.charAt(j))
        {
            len = lcsMemo(s1, s2, i-1, j-1, len, dp) + 1;
        }
        else
        {
            len = Math.max(lcsMemo(s1, s2, i, j-1, len,dp), lcsMemo(s1, s2, i-1, j, len,dp));
        }
        
        dp[i][j] = len;
        return len;
    }
    
    private static int lcsDP(String s1, String s2, int m, int n, int len, int[][] dp)
    {
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        for(int i=1; i<=s1.length(); i++)
        {
            for(int j=1; j<=s2.length(); j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
        
    }
}
