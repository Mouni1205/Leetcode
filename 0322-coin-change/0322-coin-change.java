class Solution {
    // public int helper(int[] coins, int amount, int i,Integer dp[][]) {
    //     if (i == 0) {
    //         if (amount % coins[0] == 0) return amount / coins[0];
    //         return (int) 1e9; 
    //     }

    //     if(dp[i][amount]!=null) return dp[i][amount];

    //     int notPick = helper(coins, amount, i - 1,dp);
    //     int pick = (int) 1e9;
    //     if (coins[i] <= amount)
    //         pick = 1 + helper(coins, amount - coins[i], i,dp);

    //     dp[i][amount] = Math.min(notPick, pick);
    //     return dp[i][amount];
    // }

    public int coinChange(int[] coins, int amount) {
        //Tabulation
        //write the base case and fill it 
        //for loop for the states that are changing 
        //copy the recurrence 

        //Step1:look at the memoization and come up with the base case
        //you can also just take the base of memoization as at index 0 we are just  
        //checking if the current sum is divisible so that sum can range any where from 
        //0 to the original sum as we are reducing the sum at every step.

        Integer dp[][] = new Integer[coins.length][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int) 1e9;
        }

        //Step 2: if memoization n-1 to 0 then tabulation reverse 0 to n-1

        for(int i=1;i<coins.length;i++){
            for(int t=0;t<=amount;t++){
                int notPick = dp[i-1][t];
                int pick = (int) 1e9;
                if (coins[i] <= t)
                    pick = 1 + dp[i][t - coins[i]];
                dp[i][t] = Math.min(notPick, pick);
            }
        }

        //int res = helper(coins, amount, coins.length - 1,dp);
        return dp[coins.length-1][amount] >= (int) 1e9 ? -1 : dp[coins.length-1][amount];
    }
}
