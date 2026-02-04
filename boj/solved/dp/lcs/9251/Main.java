import java.util.*;
import java.io.*;

public class Main {
  
  static String a, b;
  static int[][] dp;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    a = br.readLine();
    b = br.readLine();

    int a_len = a.length();
    int b_len = b.length();
    dp = new int[a_len + 1][b_len + 1];

    for (int i = 1; i <= a_len; i++) {
      for (int j = 1; j <= b_len; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    System.out.println(dp[a_len][b_len]);
  }
}
