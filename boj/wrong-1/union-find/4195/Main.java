import java.io.*;
import java.util.*;

public class Main {
  static int t, f;
  static HashMap<String, Integer> net;
  static int[] unf, size;

  static int find(int v) {
    if (unf[v] == v) return v;
    return unf[v] = find(unf[v]);
  }

  static int union(int a, int b) {
    int fa = find(a);
    int fb = find(b);

    if (fa != fb) {
      unf[fa] = fb;
      size[fb] += size[fa];
    } 
    return size[find(a)];
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    t = Integer.parseInt(br.readLine());
     StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      f = Integer.parseInt(br.readLine());
      net = new HashMap<>();
      int idx = 1;

      unf = new int[f * 2 + 1];
      size = new int[f * 2 + 1];
      for (int j = 0; j < f; j++) {
        st = new StringTokenizer(br.readLine());
        String a, b;
        a = st.nextToken();
        b = st.nextToken();

        if (!net.containsKey(a)) {
          net.put(a, idx);
          unf[idx] = idx;
          size[idx] = 1;
          idx ++;
        }

        if (!net.containsKey(b)) {
          net.put(b, idx);
          unf[idx] = idx;
          size[idx] = 1;
          idx ++;
        }

       sb.append(union(net.get(a), net.get(b)) + "\n") ;
      }
    }
      System.out.print(sb);

  }
}
