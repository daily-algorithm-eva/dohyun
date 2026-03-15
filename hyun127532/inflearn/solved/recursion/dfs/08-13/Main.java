import java.util.*;
import java.io.*;

// 13. 섬나라 아일랜드
// 설명

// N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

// 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

// 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

// Image1.jpg

// 만약 위와 같다면 섬의 개수는 5개입니다.


// 입력

// 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

// 두 번째 줄부터 격자판 정보가 주어진다.


// 출력

// 첫 번째 줄에 섬의 개수를 출력한다.


// 예시 입력 1 

// 7
// 1 1 0 0 0 1 0
// 0 1 1 0 1 1 0
// 0 1 0 0 0 0 0
// 0 0 0 1 0 1 1
// 1 1 0 1 1 0 0
// 1 0 0 0 1 0 0
// 1 0 1 0 1 0 0
// 예시 출력 1

// 5

public class Main {
  static int[][] map;
  static int[][] visited;
  static int n, ret;
  static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
  static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

  static void dfs(int x, int y) {
    visited[x][y] = 1;

    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
        if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
          dfs(nx, ny);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    map = new int[n+1][n+1];
    visited = new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (map[i][j] == 1 && visited[i][j] == 0) {
          ret++;
          dfs(i, j);
          
        }
      }
    }
    
    System.out.println(ret);
  }
}
