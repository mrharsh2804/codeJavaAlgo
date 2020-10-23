// "static void main" must be defined in a public class.
public class Main 
{
    public static void main(String[] args) {
        int[] p= new int[] {10,100,5,50};//{1,2,3,4,2,9,6,6,7,8};
        int[][] dp = new int[p.length][p.length];
        for(int i=0; i<p.length; i++) Arrays.fill(dp[i],-1);
        System.out.println(matrixChainMult(p,0,p.length-1,dp));
        //for(int i=0; i<p.length; i++)System.out.println(Arrays.toString(dp[i]));
    }
    
    private static int matrixChainMult(int[] A, int i, int j,int[][] dp) //10,100,5,50
    {
        if(dp[i][j]!=-1) return dp[i][j];
        if(i+1>=j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i+1; k<=j-1; k++)
        {
            int cost = matrixChainMult(A,i,k,dp);
            cost += matrixChainMult(A,k,j,dp);
            cost += A[i]*A[k]*A[j];
            if(min>cost) {
                min = cost;
            }
        }
        dp[i][j] = min;
        return min;
    }
}
