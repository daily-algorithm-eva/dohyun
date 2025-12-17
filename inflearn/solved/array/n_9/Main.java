import java.util.*;
import java.io.*;


// N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


// 입력

// 첫 줄에 자연수 N이 주어진다.(2<=N<=50)

// 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


// 출력

// 최대합을 출력합니다.

public class Main {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int max_sum = 0;

    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
     }
  }
  
  for (int i = 0; i < n; i++) {
    int horizon = 0;
    int vertical = 0;
    for (int j = 0; j < n; j++) {
      horizon += arr[i][j];
      vertical += arr[j][i];
    }
    max_sum = Math.max(max_sum, vertical);
    max_sum = Math.max(max_sum, horizon);
  }
  

      int left_diagonal = 0;
  int right_diagonal = 0;
    for (int j = 0; j < n; j++) {
      left_diagonal += arr[j][j];
      right_diagonal += arr[n-j-1][j];
    }
    max_sum = Math.max(max_sum, left_diagonal);
    max_sum = Math.max(max_sum, right_diagonal);

    System.out.println(max_sum);
  }
}
