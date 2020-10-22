// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] p= new int[] {1,2,3,4,2,9,6,6,7,8};
        int[] dp = new int[p.length+1];
        int l = 10;
        int[] s = new int[p.length+1];
        Arrays.fill(dp,-1);
        System.out.println(rodCutBT(p,l,dp,s));
        System.out.println(Arrays.toString(dp));
        findPartLengths(s,l);
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
    
    private static int rodCutBT(int[] p, int l, int[] dp, int[] s)
    {
        dp[0]=0;
        for(int i=1; i<=l; i++)
        {
            int cost= -1;
            for(int j=1; j<=i; j++)
            {
                if(cost < p[j-1]+dp[i-j])
                {
                    cost = p[j-1]+dp[i-j];
                    s[i] =j;
                }
            }
            dp[i] = cost;
        }
        
        return dp[l];
    }
    
    private static void findPartLengths(int[] s, int n)
    {
        while(n>0)
        {
            System.out.print(s[n]+" ");
            n-=s[n];
        }
    }
    
}
