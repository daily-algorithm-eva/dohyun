import java.util.*;
import java.io.*;

public class Main {

  static int n, tmp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    
    arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i ++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j+1]) {
          tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }

    for (int i :arr) {
      System.out.print(i + " ");
    }
  }

}
