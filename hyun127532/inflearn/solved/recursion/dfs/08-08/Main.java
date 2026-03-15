import java.util.*;
import java.io.*;

public class Main {

  static int n, f, flag;
  static int[] visited;
  static int[] b;
  static int[] ret;
  static int[][] memo = new int[1000][1000];

  static int combi(int n, int r) {
    if (memo[n][r] > 0 ){
      return memo[n][r];
    }

    if (n == r || r == 0) {
      return 1;
    }
    else {
      return memo[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
  }

  static void solve(int level, int sum) {
    if (flag == 1) return;

    if (level == n) {
      if (sum == f) {
        flag = 1;
        for (int i: ret) {
          System.out.print(i + " ");
        }
      }
      return ;
    }
    else {
      for (int i = 1; i <=n; i++) {
        if (visited[i] == 0) {
          visited[i] = 1;
          ret[level] = i;
          solve(level + 1, sum + ret[level] * b[level]);
          visited[i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    f = Integer.parseInt(st.nextToken());
    b = new int[n + 1];
    ret = new int[n];
    visited = new int[n+1];

    for (int i = 0; i < n; i++) {
      b[i] = combi(n-1, i);
    }
    solve(0, 0);

  }
  
}
