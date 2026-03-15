import java.util.*;
import java.io.*;

public class Main {

  static int n, l, r, negative_flag;
  static long[] arr;
  static long cur_sum, _min;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    arr = new long[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    l = 0; r = n - 1;
    _min = Long.MAX_VALUE;
  
    while (l < r) {
      cur_sum = arr[l] + arr[r];

      if (Math.abs(cur_sum) < _min) {
        if (cur_sum < 0) {
          negative_flag = 1;
        }
        else {
          negative_flag = 0;
        }
        _min = Math.abs(cur_sum);
      }

      if (cur_sum > 0) {
        r--;
      }
      else if (cur_sum < 0) {
        l++;
      }
      else {
        System.out.println(0);
        return;
      }
    }

    if (negative_flag == 1) {
      _min *= -1;
    }
    System.out.println(_min);
  }
  
}
