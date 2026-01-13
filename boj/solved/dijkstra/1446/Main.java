import java.util.*;
import java.io.*;

public class Main {

  static int n, d;
  static int dist[];
  static class Edge implements Comparable<Edge>{
    int ver;
    int cost;

    Edge(int ver, int cost) {
      this.ver = ver;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  static ArrayList<Edge>[] graph;
  static PriorityQueue<Edge> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    dist = new int[d+1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    graph = new ArrayList[d+1];

    for (int i = 0; i <= d; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i ++) {
      st= new StringTokenizer(br.readLine());
      int start, end, cost;
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      if (end - start <= cost) continue;
      if (end > d) continue;

      graph[start].add(new Edge(end, cost));
    }

    dist[0] = 0;

    pq.offer(new Edge(0, 0));

    while(!pq.isEmpty()) {

      Edge cur = pq.poll();
      int pos = cur.ver;
      int cost = cur.cost;

      if (cost > dist[pos]) continue;

      if (pos + 1 <= d  && dist[pos + 1] > cost + 1) {
        dist[pos + 1] = cost + 1;
        pq.offer(new Edge(pos + 1, dist[pos + 1]));
      }

      for (Edge e: graph[pos]) {
        if (dist[e.ver] > cost + e.cost) {
          dist[e.ver] = cost + e.cost;
          pq.offer(new Edge(e.ver, dist[e.ver]));
        }
      }

    }

    System.out.println(dist[d]);


  }
  
}
