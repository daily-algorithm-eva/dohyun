import java.util.*;
import java.io.*;

public class Main {
  
  static int n, k, ret, zero_cnt, cur_max, left_one;
  static int[] arr;

  static Queue<Integer> q = new LinkedList<>();
  
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        cur_max++;
        left_one++;
      }
      if (arr[i] == 0) {
        if (q.size() == k) {
          ret = Math.max(ret, cur_max);
          cur_max -= q.poll();
          q.add(left_one);
        }
        else {
          q.add(left_one);
        }
          left_one = 0;
      }
    }
    System.out.println(ret + k);
  }
}
