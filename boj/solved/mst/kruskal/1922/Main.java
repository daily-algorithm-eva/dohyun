import java.util.*;
import java.io.*;

public class Main {
  static int n, m, ret;
  static int[] unf, size;
  static List<Edge> edges;

  static class Edge implements Comparable<Edge> {
    int from, to, cost;

    Edge (int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
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

  static int find(int v) {
    if (unf[v] == v) return v;
    return unf[v] = find(unf[v]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    unf = new int[n+1];
    size = new int[n+1];
    edges = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      unf[i] = i;
      size[i] = 1;
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

    for (Edge e: edges) {
      int from = e.from;
      int to = e.to;
      int cost = e.cost;
      // 여기서 간선 갯수 n-1까지 break;
      if (find(from) != find(to)) {
        union(from, to);
        ret += cost;
      }
    }
    System.out.println(ret);
  }
}
