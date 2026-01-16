import java.util.*;
import java.io.*;

public class Main {

  static int v, e, a, b, c ;
  static long ret;

  static PriorityQueue<Edge> pq = new PriorityQueue<>();
  static List<Edge>[] graph;
  static int[] visited;

  static class Edge implements Comparable<Edge> {
    int to, cost;
    
    Edge (int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    graph = new ArrayList[v+1];
    for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
      }
    visited = new int[v+1];

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      graph[a].add(new Edge(b, c));
      graph[b].add(new Edge(a, c));
    }

    pq.offer(new Edge(1, 0));

    while(!pq.isEmpty()) {
      Edge tmp = pq.poll();
      int to = tmp.to;
      int cost = tmp.cost;
      if (visited[to] == 1) continue;
      visited[to] = 1;
      ret += cost;

      for (Edge e: graph[to]) {
        if (visited[e.to] == 0) {
          pq.offer(new Edge(e.to, e.cost));
        }
      }

    }
    System.out.println(ret);
  }
  
}
