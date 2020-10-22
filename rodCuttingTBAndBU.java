// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] p= new int[] {1,2,3,4,9,5,6,6,7,8};
        int[] dp = new int[p.length+1];
        Arrays.fill(dp,-1);
        System.out.println(rodCut(p,9,dp));
    }
    
    private static int rodCut(int[] p, int l, int[] dp)
    {    
        if(dp[l]>=0) return dp[l];
        int cost;
        if(l==0) return cost = 0;
        else 
        {
            cost = -1;
            for(int i=1; i<=l; i++)
            {
                cost = Math.max(cost,p[i-1]+rodCut(p,l-i,dp));
            }
        }
        dp[l] = cost;        
        
        return cost;
    }
    
    private static int rodCutBT(int[] p, int l, int[] dp)
    {
        dp[0]=0;
        for(int i=1; i<=l; i++)
        {
            int cost= -1;
            for(int j=1; j<=i; j++)
            {
                cost = Math.max(cost,p[j-1]+dp[i-j]);
            }
            dp[i] = cost;
        }
        
        return dp[dp.length-1];
    }
    
}
