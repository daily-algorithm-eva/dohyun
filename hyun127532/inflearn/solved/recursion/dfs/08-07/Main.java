import java.io.*;
import java.util.*;

// 7. 조합의 경우수(메모이제이션)
// 설명

// Image1.jpg로 계산합니다.

// 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

// Image1.jpg


// 입력

// 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


// 출력

// 첫째 줄에 조합수를 출력합니다.


// 예시 입력 1 

// 5 3
// 예시 출력 1

// 10
// 예시 입력 2 

// 33 19
// 예시 출력 2

// 818809200

public class Main {

  static int n, r, ret;
  static int memo[][] = new int[35][35];

  static int permutation(int n, int r) {

    if(memo[n][r] > 0) {
      return memo[n][r];
    }

    if (n == r) {
      return 1;
    }

    if (r == 1) {
      return n;
    }

    return memo[n][r] = permutation(n-1, r-1) + permutation(n-1, r);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    System.out.println(permutation(n, r));
  }
}