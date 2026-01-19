import java.util.*;
import java.io.*;

public class Main {
  
  static int n,  _max;
  static int[] arr, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    arr = new int[n];
    dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      _max = 0;
      for (int j = i-1; j >= 0; j--) {
        if (arr[j] < arr[i] && dp[j] > _max) {
          _max = dp[j];
        }
      }
        dp[i] = _max + 1;

    }

    for (int i: dp) {
      _max = Math.max(i, _max);
    }

    System.out.println(_max);
  }
}
