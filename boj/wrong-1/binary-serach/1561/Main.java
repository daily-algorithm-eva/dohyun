import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] times;

  static long binarySearch() {
    long l = 0, r = 2000000000L * 30L;

    while(l < r) {
      long cnt = m;
      long mid = (l + r) / 2;

      for (int i = 0; i < m; i++) {
        cnt += mid / times[i];
      }

      if (cnt >= n) {
        r = mid;
      }
      
      else {
        l = mid + 1;
      }

    }

    return l;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    times = new int[m];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i ++) {
      times[i] = Integer.parseInt(st.nextToken());
    } 

    if (n <= m) {
      System.out.println(n);
      return;
    }



    long resultTime = binarySearch();
    long ret = m;

    for (int i = 0; i < m; i++) {
      ret += (resultTime - 1) / times[i];
    }

    for (int i = 0; i < m; i++) {
      if (resultTime % times[i] == 0) {
        ret++;
      }

      if (ret == n) {
        System.out.println(i + 1);
        break;
      }
    }

  }
}
