import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static double ret;
  
  static Point[] points;
  static int[] visited;
  static List<State>[] graph;
  static PriorityQueue<State> pq = new PriorityQueue<>();

  static double dist(Point a, Point b) {
    return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
  }

  static class State implements Comparable<State>{
    int idx;
    double cost;

    State(int idx, double cost) {
      this.idx = idx;
      this.cost = cost;
    }

    public int compareTo(State s) {
      return Double.compare(this.cost, s.cost);
    }
  }

  static class Point {
    double x, y;
    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    visited = new int[n+1];
    points = new Point[n+1];
    graph = new ArrayList[n+1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    StringTokenizer st;

    for (int i = 1; i <= n; i ++) {
      st = new StringTokenizer(br.readLine());
      double x, y;
      x = Double.parseDouble(st.nextToken());
y = Double.parseDouble(st.nextToken());

      points[i] = new Point(x, y);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;
        graph[i].add(new State(j, dist(points[i], points[j])));
      }
    }

    pq.offer(new State(1, 0));

    while (!pq.isEmpty()) {
      State s = pq.poll();
      if (visited[s.idx] == 1) continue;
      visited[s.idx] = 1;
      ret += s.cost;
      for (State tmp: graph[s.idx]) {
        if (visited[tmp.idx] == 0) {
          pq.offer(new State(tmp.idx, tmp.cost));
        }
      }

    }

    System.out.println(ret);
  }
}
