import java.util.*;
import java.io.*;


public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n, m, ret;
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[m+1][n+1];
    ret = 0;

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      
      int[] idx = new int[n+1];
      for (int l = 1; l <= n; l++) {
        if (l == i) continue;
        idx[l] = 1;
      }

      for (int j = 1; j <= m; j++) {
        int flag = 0;

          for (int k = 1; k <= n; k++ ){
            if (arr[j][k] == i) {
              flag = 1;
              continue;
            }
            if(flag == 0) {
              idx[k] = 0;
            }
          }

      }
      for (int x = 1; x <= n; x++){
        ret += idx[x];
      }
    }
    System.out.println(ret);
  }
  
}
