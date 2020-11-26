class Solution {
    int count, total;
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount+1];
        if(amount <=0) return 1;
        if(coins.length == 0) return 0;
        //return helper(amount, coins.length, coins, memo);
        return helperDP(amount, coins);
    }
    
    public int helper(int amount, int start, int[] coins, int[] memo)
    {
        if(start == 0) return 0;
        if(amount==0) return 1;
        if(amount < coins[start-1])
        {
            memo[amount] = helper(amount, start-1,coins, memo);
            return memo[amount];
        }
        memo[amount]= helper(amount-coins[start-1], start, coins, memo) +
               helper(amount, start-1, coins, memo);
        return memo[amount];
    }
    
    public int helperDP(int amount, int[] coins)
    {
        int[] dp = new int[amount +1];
        dp[0] = 1;
        for(int c : coins)
        {
            for(int i=1; i<=amount; i++)
            {
                if(i-c>=0)
                    dp[i] = dp[i-c] + dp[i];
            }
        }
        return dp[amount];
    }
    
}
