import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[][] arr, visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static PriorityQueue<Point> pq = new PriorityQueue<>();

  static class Point implements Comparable<Point>{
    int x, y, wall;

    Point(int x, int y, int wall) {
      this.x = x;
      this.y = y;
      this.wall = wall;
    }

    public int compareTo(Point p) {
      return this.wall - p.wall;
    }
  }

  static void solve() {

    while(!pq.isEmpty()) {

      Point cur = pq.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {

          if (arr[nx][ny] == 1) {
            if (visited[nx][ny] > cur.wall) {
              visited[nx][ny] = cur.wall;
              pq.offer(new Point(nx, ny, visited[nx][ny]));
            }
          }
          

          else {
           if (visited[nx][ny] > cur.wall + 1) {
            visited[nx][ny] = cur.wall + 1;
            pq.offer(new Point(nx, ny, visited[nx][ny]));
          }
          
          }
        } 
      }

    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];
    visited = new int[n][n];

    for (int i = 0; i < n; i ++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < n; j++) {
        arr[i][j] = tmp[j] - '0';
      }
    }


    for (int i = 0; i < n; i++) {
      Arrays.fill(visited[i], Integer.MAX_VALUE);
    }

    pq.offer(new Point(0, 0, 0));
    visited[0][0] = 0;

    solve();

    System.out.println(visited[n-1][n-1]);


  }
  
}
