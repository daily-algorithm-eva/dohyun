package inflearn.solved.recursion.dfs.n_6;
import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[] visited;
  static StringBuilder sb ;

  
  static void dfs(int level) {
    if (level == n+1) {
      sb = new StringBuilder();

      for (int i = 0; i < n+1; i++) {
        if (visited[i] == 1) {
          sb.append(i + " ");
        }
      }
      System.out.println(sb.toString());
      return;
    }

    else {
      visited[level] = 1;
      dfs(level + 1);
      visited[level] = 0;
      dfs(level + 1);
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    visited = new int[n+1];

    dfs(1);

  }
  
}
