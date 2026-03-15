import java.util.*;
import java.io.*;

public class Main {

  static int n, m, ret = Integer.MAX_VALUE;
  static int[][] map;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static List<Point> cctv = new ArrayList<>();

  static class Point {
    int x, y, n;

    Point(int x, int y, int n) {
      this.x = x;
      this.y = y;
      this.n = n;
    }
  }
  
  static void check(int[][] arr, int x, int y, int i) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
      if (arr[nx][ny] == 6) 
        break;
      if (arr[nx][ny] == 0) 
        arr[nx][ny] = 9;
      
      nx += dx[i];
      ny += dy[i];
    }

  }

  static void solve(int[][] arr, int index) {
    // cctv 다 돌았을 때
    if (index == cctv.size()) {
      int tmp = 0;
      for (int i = 0; i < n; i ++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] == 0) tmp++;

        }
      }

      ret = Math.min(ret, tmp);
      return;
    }

    

    Point cur = cctv.get(index);
    
    for (int i = 0; i < 4; i++) {

    int[][] copy = new int[n][m];

      for (int j = 0; j < n; j++) {
       copy[j] = arr[j].clone();
      }

        if (cur.n == 1) {
          
          check(copy, cur.x, cur.y, i);
        }

        else if (cur.n == 2) {
          check(copy, cur.x, cur.y, i);
          check(copy, cur.x, cur.y, (i + 2) % 4);
        }

        else if (cur.n == 3) {
          check(copy, cur.x, cur.y, i);
          check(copy, cur.x, cur.y, (i + 1) % 4);

        }

        else if (cur.n == 4) {
          check(copy, cur.x, cur.y, i);
          check(copy, cur.x, cur.y, (i + 1) % 4);
          check(copy, cur.x, cur.y, (i + 2) % 4);
        }

        else {
          check(copy, cur.x, cur.y, i);
          check(copy, cur.x, cur.y, (i+1) % 4);
          check(copy, cur.x, cur.y, (i+2) % 4);
          check(copy, cur.x, cur.y, (i+3) % 4);
        }
        solve(copy, index + 1);
      }



  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] >= 1 && map[i][j] <= 5) {
          cctv.add(new Point(i, j, map[i][j]));
        }
      }
    }

    solve(map, 0);

    System.out.println(ret);

  }
}
