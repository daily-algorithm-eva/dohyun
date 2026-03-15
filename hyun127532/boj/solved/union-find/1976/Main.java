import java.util.*;
import java.io.*;

public class Main {

  static int n, m, flag = 1;
  static int unf[];
  
  static void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);

    if (fa != fb) {
      unf[fa] = fb;
    }
  }
  
  static int find(int v) {
    if (unf[v] == v) return v;

    return unf[v] = find(unf[v]);
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    
    unf = new int[n+1];

    for (int i = 0; i <= n; i++ ) {
      unf[i] = i;
    }


    StringTokenizer st; 


    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        if (i == j)  {
          st.nextToken();
          continue;
        }
        int ch = Integer.parseInt(st.nextToken());
        if (ch == 1) {
          union(i, j);
        }
      }
    }

    st = new StringTokenizer(br.readLine());

    int bef = find(Integer.parseInt(st.nextToken()));
    
    for (int i = 1; i < m; i++) {
      int cur = find(Integer.parseInt(st.nextToken()));

      if (bef != cur) flag = 0;
      bef = cur;
    }

    if (flag == 0) {
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
  }
}
