import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    char[] arr = str.toCharArray();

    int l = 0;
    int r = arr.length - 1;

    while (l < r) {
      if (!Character.isAlphabetic(arr[l])) {
        l++;
      }
      else if (!Character.isAlphabetic(arr[r])) {
        r--;
      }
      else {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
        l++;
        r--;
      }

    }
    System.out.print(new String(arr));
}
}
