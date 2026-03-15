import java.util.*;
import java.io.*;

public class Main {
  static int[] parent;
  static int[] visited;
  static int[] children;
  static List<Integer>[] graph;
  static int n, r, q;

  static int solve(int cur) {

    visited[cur] = 1;

      for(int next: graph[cur]) {
        if (visited[next] == 0) {
            parent[next] = cur;
            children[cur] += solve(next);
          }    
        }
      return children[cur];
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    children = new int[n+1];
    visited = new int[n+1];
    Arrays.fill(children, 1);
    graph = new ArrayList[n+1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());

      int from, to;
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      graph[from].add(to);
      graph[to].add(from);
    }
    solve(r);
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      System.out.println(children[node]);
    }
  }
}
