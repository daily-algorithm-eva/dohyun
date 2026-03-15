import java.util.*;
import java.io.*;

public class Main {
  
  static int n, m, ret;
  static int[][] arr;
  static int[] visited;


  static void dfs(int cur) {
      if (cur == n) {
        ret++;
      }
      else {
      for (int i = 1; i <= n; i++) {
        if (arr[cur][i] == 1 && visited[i] == 0) {
          visited[i] = 1;
          dfs(i);
          visited[i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n+1][n+1];
    visited = new int[n+1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int cur, to;
      cur = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      
      arr[cur][to] = 1;

    }

    visited[1] = 1;

    dfs(1);
    
    System.out.println(ret);
  }
}
