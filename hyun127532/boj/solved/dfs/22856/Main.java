import java.util.*;
import java.io.*;

public class Main {

  static int[] visited, left, right;
  static int n, a, b, c, ret, flag, end;


  static void solve(int cur) {
    if (flag == 1) return;
    if (left[cur] != -1) {
      ret++;
      solve(left[cur]);
      if (flag == 1) return;
      ret++;
    }

    if (right[cur] != -1) {
      ret++;
      solve(right[cur]);
      if (flag == 1) return ;
      ret++;
    }

    if (cur == end) flag = 1;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    
    left = new int[n+1];
    right = new int[n+1];

    if (n == 1) {
      System.out.println(0);
      return;
    }
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      left[a] = b;
      right[a] = c;
      
    }

    int cur = end =1;
    while(right[end] != -1) {
      end = right[end];
    }

    solve(cur);


    System.out.println(ret);
  }
}
