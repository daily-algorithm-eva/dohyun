import java.util.*;
import java.io.*;

// 2. 괄호문자제거
// 설명

// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.


// 입력

// 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


// 출력



public class Main {

  static Stack<Character> stk = new Stack<>();
  static char[] arr;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    arr = br.readLine().toCharArray();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        stk.push(arr[i]);
      }
      else if (arr[i] == ')') {
        stk.pop();
      }
      else {
        if(stk.empty()) {
        sb.append(arr[i]);
        }
      }
  
    }

System.out.println(sb);
  }
}
