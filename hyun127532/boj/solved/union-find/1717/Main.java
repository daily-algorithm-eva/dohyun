import java.io.*;
import java.util.*;

public class Main {

  static int[] unf;
  static int n, m;

  static int find(int v) {
    if (v == unf[v]) return v;
    return unf[v] = find(unf[v]);
  }

  static void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);

    if (fa != fb) {
      unf[fa] = fb;
    }
  }
  

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    unf = new int[n+1];

    for (int i = 0; i <= n; i++) {
      unf[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int op, a, b;
      op = Integer.parseInt(st.nextToken());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      if (op == 1) {
        int fa, fb;
        fa = find(a); fb = find(b);
        if (fa != fb) {
          System.out.println("NO");
        }
        else {
          System.out.println("YES");
        }
      }

      else {
        union(a, b);
      }
    }

  }
}
