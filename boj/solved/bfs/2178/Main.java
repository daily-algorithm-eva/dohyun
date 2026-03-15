import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[][] arr, visited;
  static Queue<Point> q = new LinkedList<>();
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static class Point{
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static void bfs() {

    while(!q.isEmpty()) {
      Point cur = q.poll();

      int cur_x = cur.x;
      int cur_y = cur.y;


      for (int i = 0; i < 4; i++) {


        int nx = cur_x + dx[i];
        int ny = cur_y + dy[i];

        if (nx > 0 && nx <= n && ny > 0 && ny <= m && arr[nx][ny] == 1) {
          if (visited[nx][ny] > visited[cur_x][cur_y] + 1) {
            visited[nx][ny] = visited[cur_x][cur_y] +1;
            q.offer(new Point(nx, ny));
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n+1][m+1];
    visited = new int[n+1][m+1];

    for (int i = 1; i <= n; i++) {
      Arrays.fill(visited[i], Integer.MAX_VALUE);
    }

    for (int i = 1; i <= n; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 1; j <= m; j++) {
        arr[i][j] = tmp[j-1] - '0';
      }
    }

    q.offer(new Point(1, 1));
    visited[1][1] = 1;

    bfs();

    System.out.println(visited[n][m]);
  }
}
