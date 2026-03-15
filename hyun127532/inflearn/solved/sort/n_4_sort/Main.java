import java.util.*;
import java.io.*;


public class Main {

  static int[] cache;
  static int s, n;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    s = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    cache = new int[s];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int cur = Integer.parseInt(st.nextToken());
      boolean hit = false;
      for (int j = 0; j < s; j++) {
        if (cache[j] == cur) {
          hit = true;
          for (int k = j - 1; k >= 0; k--) {
            cache[k+1] = cache[k];
          }
          cache[0] = cur;
          break;
        }
      }
      if (!hit) {
        for (int j = s-1; j > 0; j--) {
          cache[j] = cache[j-1];
        }
        cache[0] = cur;

    
    }
  } 
      for (int i: cache) {
        System.out.print(i + " ");
    }
  }
}
