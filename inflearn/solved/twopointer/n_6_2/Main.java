import java.util.*;
import java.io.*;

public class Main {
  static int n, k, ret, zero_cnt, l, r, cur;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[n];

    for (int i = 0; i < n ; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    while (r < n) {
      if (arr[r] == 0) {
        zero_cnt++;
        while (zero_cnt > k) {
          if (arr[l] == 0) {
            zero_cnt--;
          }
          cur--;
          l++;
        }
      }
      cur++;
      ret = Math.max(ret, cur);
      r++;
    }
    System.out.println(ret);
  }
}
