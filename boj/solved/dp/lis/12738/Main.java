import java.util.*;
import java.io.*;

public class Main {

  static int n, len, pos;
  static int[] arr, dp;
  
  static int lowerBound(int l, int r, int target) {

    while(l < r) {
      int mid = (l+r) / 2;
      if (dp[mid] < target) l = mid + 1;
      else r = mid;
    }

    return l;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    dp = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0 ; i < n; i++) {
      int target = arr[i];
      pos = lowerBound(0, len, target);

      dp[pos] = target;
      if (pos == len) len++;
    }

    System.out.println(len);

  }
}
