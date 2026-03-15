import java.util.*;
import java.io.*;

// 설명

// 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

// 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


// 입력

// 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


// 출력

// 첫 줄에 소수의 개수를 출력합니다.

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int n = Integer.parseInt(br.readLine());
    int ret = 0;
    int[] isPrime = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      isPrime[i] = 1;
    }

    isPrime[1] = isPrime[2] = 1;

    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i] == 1) {
      for (int j = i*i ; j <= n; j += i) {
          isPrime[j] = 0;    
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (isPrime[i] == 1) {
        ret++;
      } 
    }
    System.out.println(ret);
  }
}
