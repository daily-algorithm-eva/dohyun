import java.util.*;
import java.io.*;

public class Main {

  static int n, m, start, end;
  static int[] dist;
  static List<Edge>[] graph;
  static PriorityQueue<Edge> pq = new PriorityQueue<>();

  static class Edge implements Comparable<Edge>{
    int to, cost;

    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
    
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
  
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    graph = new ArrayList[n+1];

    for (int i = 0; i <= n; i++) 
      graph[i] = new ArrayList<>();


    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from, to, cost;
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Edge(to, cost));
    }

    st = new StringTokenizer(br.readLine());
    
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    pq.offer(new Edge(start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Edge tmp = pq.poll();

      if (tmp.cost > dist[tmp.to]) continue;

      for (Edge next: graph[tmp.to]) {
        if (dist[next.to] > next.cost + dist[tmp.to]) {
          dist[next.to] = next.cost + dist[tmp.to];
          pq.offer(new Edge(next.to, next.cost + dist[tmp.to]));
        }
      }
    }

    System.out.println(dist[end]);
  }
  
}
