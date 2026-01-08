import java.util.*;
import java.io.*;

public class Main {

  static int n, c, ret;
  static int[] arr;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());


    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int lt = 1;
    int rt = arr[n - 1];


    while (lt <= rt) {
      int cnt = 1;
      int cur = arr[0];
      int mid = (lt + rt) / 2;
      
      for (int i = 1; i < n; i++) {
        if (arr[i] - cur >= mid) {
          cnt++;
          cur = arr[i];
        }
      }

      if (cnt >= c) {
        ret = mid;
        lt = mid + 1;
      }
      else {
        rt = mid - 1;
      }

    }

    System.out.println(ret);
  }
  
}
