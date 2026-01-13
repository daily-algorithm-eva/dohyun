import java.util.*;
import java.io.*;

public class Main {

  static int v, e, start;
  static int[] dist;
  
  static List<Edge>[] graph;
  static PriorityQueue<Edge> pq = new PriorityQueue<>();
  
  static class Edge implements Comparable<Edge> {
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
    StringTokenizer st = new StringTokenizer(br.readLine());

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());

    graph = new List[v+1];
    for (int i = 1; i <= v; i++) {
    graph[i] = new ArrayList<>();
}
    dist = new int[v+1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 1; i <= e; i++) {
      st = new StringTokenizer(br.readLine());
      int from, to, cost;

      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Edge(to, cost));
    }

    dist[start] = 0;
    pq.offer(new Edge(start, 0));

    while(!pq.isEmpty()) {
      Edge tmp = pq.poll();

      if(tmp.cost > dist[tmp.to]) continue;

      for (Edge next: graph[tmp.to]) {
        if (dist[next.to] > tmp.cost + next.cost) {
          dist[next.to] = tmp.cost + next.cost;
          pq.offer(new Edge(next.to, dist[next.to]));
        }
      }
    }

    for (int i= 1; i <= v; i++) {
      if (dist[i] == Integer.MAX_VALUE) 
        System.out.println("INF");
      else {
        System.out.println(dist[i]);
      }
    }
  }
  
}
