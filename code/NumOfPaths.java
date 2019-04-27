import java.io.*;
import java.util.*;


//solution 1 using dfs
class NumOfPaths {

  static int numOfPathsToDest(int n) {
    // your code goes here
    int[][] memo = new int[n][n];
    return numOfPathsToDest(0, 0, memo);
  }
  static int numOfPathsToDest(int i, int j, int[][] memo) {
    int n = memo.length;
    if (i > j || i == n || j == n) {
      return 0;
    }
    if (memo[i][j] > 0) {
      return memo[i][j];
    }
    if (i == n - 1 && j == n - 1) {
      memo[i][j] = 1;
    } else {
      memo[i][j] = numOfPathsToDest(i + 1, j, memo) + numOfPathsToDest(i, j + 1, memo);
    }
    return memo[i][j];
  }

  public static void main(String[] args) {

  }
}


//solution 2 using dp
class NumOfPaths {

  static int numOfPathsToDest(int n) {
    // your code goes here
    if (n <= 0) {
      return 0;
    }
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = i; j < n; j++) {
        dp[j] = i == j ? dp[j] : dp[j] + dp[j - 1];
      }
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {

  }
}