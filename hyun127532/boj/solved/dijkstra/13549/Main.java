import java.util.*;
import java.io.*;

public class Main {
  static int n, k;
  static int[] visited;
  static int[] dx = {-1, 1};

  static class Edge implements Comparable<Edge>{
    int vertex, cost;

    Edge (int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  static PriorityQueue<Edge> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());


    if (n == k) {
      System.out.println(0);
      return;
    }
    visited = new int[100001];
    Arrays.fill(visited, Integer.MAX_VALUE);
    visited[n] = 0;
    pq.offer(new Edge(n, 0));


    while(!pq.isEmpty()) {
      Edge e = pq.poll();

      int ver = e.vertex;
      int cost = e.cost;
      
      if (ver == k) {
        System.out.println(cost);
        break;
      }
      // 2*X
      if (ver * 2 <= 100000) {
        if (visited[ver * 2] > visited[ver]) {
          visited[ver * 2] = cost;
          pq.offer(new Edge(ver * 2, cost));
        }
      }

      // X+1, X-1
      for (int i: dx) {
        int next = ver + i;
        if (next >= 0 && next <= 100000) {
          if (visited[next] > visited[ver] + 1) {
            visited[next] = visited[ver] + 1;
            pq.offer(new Edge(next, cost + 1));
          }
        }
      }
    }


    

  }
}
