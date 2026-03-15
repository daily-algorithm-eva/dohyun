import java.util.*;
import java.io.*;

public class Main {
  static int n, m, ret, max_cost;

  static List<Edge>[] graph;
  static int[] visited;
  static PriorityQueue<Edge> pq = new PriorityQueue<>();

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

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    if (n == 2) {
      System.out.println(0);
      return;
    }
    visited = new int[n+1];
    graph = new ArrayList[n+1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from, to, cost;

      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Edge(to, cost));
      graph[to].add(new Edge(from, cost));
    }

    pq.offer(new Edge(1, 0));

    
    while(!pq.isEmpty()) {
      Edge tmp = pq.poll();
      
      int to = tmp.to;
      int cost = tmp.cost;
      if (visited[to] == 1) continue;
      ret += cost;
      max_cost = Math.max(max_cost, cost);
      visited[to] = 1;

      for (Edge e: graph[to]) {
        if (visited[e.to] == 0) {
          pq.offer(new Edge(e.to, e.cost));
        }
      }
    } 

    System.out.println(ret - max_cost);
  }
}
