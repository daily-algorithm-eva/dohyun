import java.util.*;
import java.io.*;


public class Main {

  static char[] arr;
  static char before = ')', tmp;
  static int ret, tmp_stick;
  static Stack<Character> stk = new Stack<>();

  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = br.readLine().toCharArray();

    for (char cur: arr) {
      if (cur == '(') {
        stk.push(cur);
        tmp_stick++;
      }

      else {
        stk.pop();

        if (before == '(') {
            tmp_stick--;
            ret += tmp_stick;
        }
        if (before == ')') {
            tmp_stick--;
            ret++;
        }
        
      }
        before = cur;

    }
    System.out.println(ret);
  }
  
}
