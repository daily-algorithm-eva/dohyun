import java.util.*;
import java.io.*;


public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n+1][6];
    int ret = 1, cnt = -1;
    
    
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 5; j ++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      int tmp = 0;
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          continue;
        }
        for (int k = 1; k <= 5; k++) {
          if (arr[i][k] == arr[j][k]) {
            tmp++;
            break;
          }
        }
      }
      if (tmp > cnt) {
        cnt = tmp;
        ret = i;
      }
      
    }
    System.out.println(ret);
  }
  
}
