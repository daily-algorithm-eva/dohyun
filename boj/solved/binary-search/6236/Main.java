import java.util.*;
import java.io.*;

public class Main {
  
  static int n, m, ret;
  static int[] money;
  
  static void solve() {
    int l, r;
    l = 0;
    // 1_000_000_000
    r = 100000 * 10000;

    for (int m: money) {
      l = Math.max(l, m);
    }
    while (l < r) {
      int cnt = 0;
      int tmp = 0;

      int mid = (l + r) / 2;
      tmp = mid;
      cnt++;

      for (int i = 0; i < n; i++) {
        if (tmp < money[i]) {
          tmp = mid;
          cnt++;
        }
        tmp -= money[i];
      }

      if(cnt <= m) {
        r = mid;
      }
      
      else {
        l = mid + 1;
      }
    }
    ret = l;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    money = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      money[i] = Integer.parseInt(st.nextToken());
    }

    solve();
    System.out.println(ret);
  }
}
