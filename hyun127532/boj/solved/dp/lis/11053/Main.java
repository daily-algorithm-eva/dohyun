import java.util.*;
import java.io.*;

public class Main {
  static int n, ret;
  static int[] dp, arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    dp = new int[n];
    arr = new int [n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      int _max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i] > arr[j] && _max < dp[j]) {
          _max = dp[j];
        }
      }
      dp[i] = _max + 1;
    }

    for (int i: dp) {
      ret = Math.max(ret, i);
    }

    System.out.println(ret);
  }
}
