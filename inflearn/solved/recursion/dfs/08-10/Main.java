import java.util.*;
import java.io.*;

// 10. 미로탐색(DFS)
// 설명

// 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.

// 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.

// 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

// Image1.jpg

// 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.


// 입력

// 7*7 격자판의 정보가 주어집니다.


// 출력

// 첫 번째 줄에 경로의 가지수를 출력한다.


// 예시 입력 1 

// 0 0 0 0 0 0 0
// 0 1 1 1 1 1 0
// 0 0 0 1 0 0 0
// 1 1 0 1 0 1 1
// 1 1 0 0 0 0 1
// 1 1 0 1 1 0 0
// 1 0 0 0 0 0 0
// 예시 출력 1

// 8

public class Main {

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[][] arr = new int[8][8];
  static int[][] visited = new int[8][8];
  static int ret;

  static void dfs(int x, int y) {
    if (x == 7 && y == 7) {
      ret++;
      return;
    }
    else {
      visited[x][y] = 1;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx > 0 && nx <= 7 && ny > 0 && ny <= 7) {
          if (arr[nx][ny] == 0 && visited[nx][ny] == 0) {
            System.out.println(nx + " " + ny);
            dfs(nx, ny);
          }
        }
      }
      visited[x][y] =0;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 1; i <= 7; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 7; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    dfs(1, 1);
    System.out.println(ret);
  } 
  
}
