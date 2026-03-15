import java.util.*;
import java.io.*;


public class Main {

  static char[] arr;
  static Stack<Character> stk = new Stack<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = br.readLine().toCharArray();

    stk.push(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == '(') {
        stk.push(arr[i]);
      }

      else {
        if (stk.empty()) {
          System.out.println("NO");
          return;
        }
        else {
          stk.pop();
        }
      }
    }

    if (stk.empty()) {
      System.out.println("YES");
      return;
    }

    System.out.println("NO");
  }
}
