package exercises.array;

public class CoinExchange {
  public int coinChange(int[] coins, int amount) {
    int dp[] = new int[amount + 1];
    for(int i = 1; i <= amount; i++){
      int min = Integer.MAX_VALUE;
      for(int coin : coins){
        if(i- coin >=0 && dp[i-coin] != -1) {
          min = Math.min(dp[i - coin], min);
        }
      }
      dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
    }
    return dp[amount];
  }
}
