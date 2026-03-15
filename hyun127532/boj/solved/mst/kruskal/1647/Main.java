import java.util.*;
import java.io.*;

public class Main {
  static int n, m, ret;
  static int[] unf, size;
  static List<Edge> edges;

  static class Edge implements Comparable<Edge> {
    int from, to, cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return Integer.compare(this.cost, e.cost);
    }
  }

  static int find(int v) {
    if (unf[v] == v) return v;
    return unf[v] = find(unf[v]);
  }

  static int union(int a, int b) {
    int fa = find(a);
    int fb = find(b);

    if(fa != fb) {
      unf[fa] = fb;
      size[fb] += size[fa];
    }
    return size[find(a)];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    edges = new ArrayList<>();
    unf = new int[n+1];
    size = new int[n+1];

    for (int i = 1; i <= n; i++) {
      unf[i] = i;
      size[i] = 1;
    }

    if (n == 2) {
      System.out.println(0);
      return;
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from, to, cost;
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      edges.add(new Edge(from, to, cost));

    }
    edges.sort(null);

    int cnt = 0;

    int from = 0, to = 0, cost = 0;
    for (Edge e: edges) {
      

      from = e.from;
      to = e.to;
      cost = e.cost;

      if (find(from) != find(to)) {
        union(from, to);
        cnt++;
        ret += cost;
      }

      if (cnt == n-2) break;

    }

    System.out.println(ret);

  }
}
