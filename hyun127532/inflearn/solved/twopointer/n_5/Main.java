import java.util.*;
import java.io.*;

// 5. 연속된 자연수의 합
// 설명

// N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

// 만약 N=15이면

// 7+8=15

// 4+5+6=15

// 1+2+3+4+5=15

// 와 같이 총 3가지의 경우가 존재한다.


// 입력

// 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


// 출력

// 첫 줄에 총 경우수를 출력합니다.




public class Main {
  
  static int n, cur, ret;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    int l = 1, r = 1;

    while (r < n) {
      cur += r;
      r++;

      while(cur >= n) {
        if (cur == n) ret++;

        cur -= l;
        l++;
      }
    }
    System.out.println(ret);
  }
  
}
