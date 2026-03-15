import java.io.*;
import java.util.*;

public class Main {

  static int n, len, pos;
  static int[] arr, dp;

  
  static int lowerBound(int left, int right, int target) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (dp[mid] >= target) right = mid;
      else left = mid + 1;
    }
    // target이 들어갈 수 있는 자리중 가장 작은 위치
    // 즉, 현재 수열 중 target보다 큰 수중 가장 작은 수 위치
    return left;
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

    for (int i = 0; i < n; i++) {
      int target = arr[i];
      int pos = lowerBound(0, len, target);
      dp[pos] = target;

      if (pos == len) {
        len++;
      }
    }

    System.out.println(len);
  }
}
