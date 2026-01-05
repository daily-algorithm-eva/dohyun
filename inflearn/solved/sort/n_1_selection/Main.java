import java.util.*;
import java.io.*;

public class Main {

  static int n, least;
  static int[] arr;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[n];


    for (int i = 0 ; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      least = i;

      for (int j = i+1; j <n; j++) {
        if (arr[least] > arr[j]) {
          least = j;
        }

      
      }
        if (least != i) {
          int tmp = arr[i];
          arr[i] = arr[least];
          arr[least] = tmp;
        }
    }

    for (int i : arr) {
      System.out.print(i + " ");
    }
   }
  
  
}
