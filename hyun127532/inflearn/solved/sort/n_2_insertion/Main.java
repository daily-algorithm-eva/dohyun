import java.util.*;
import java.io.*;

public class Main {
  
  static int n;
  static int arr[];

  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < n; i++) {

      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = key;
    }

    for (int i: arr) {
      System.out.print(i + " ");
    }
  }
}
