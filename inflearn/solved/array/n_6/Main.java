import java.util.*;
import java.io.*;

// 설명

// N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.

// 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.

// 첫 자리부터의 연속된 0은 무시한다.


// 입력

// 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.

// 각 자연수의 크기는 100,000를 넘지 않는다.


// 출력

// 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.


public class Main {
  public static void main(String[] args) throws IOException{
    int n;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    List<Integer> ret = new ArrayList<>();

    n = Integer.parseInt(br.readLine());


    int[] isPrime = new int[100001];

    for (int i = 2; i <= 100000; i++) {
      isPrime[i] = 1;
    }

    for (int i = 2; i*i <= 100000; i++) {
      if(isPrime[i] == 1) {      
        for (int j = i*i; j <= 100000; j+=i) {
          isPrime[j] = 0;
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
      int tmp_ret = 0;
      sb.append(st.nextToken());
      char[] tmp = sb.toString().toCharArray();
      
      for (int j = tmp.length - 1; j >= 0; j--) {
        tmp_ret *= 10;
        tmp_ret += tmp[j] - '0';
      }

      if (isPrime[tmp_ret] == 1) {
        ret.add(tmp_ret);
      }
      sb.setLength(0);

    }

    for (int result: ret) {
      System.out.print(result + " ");
    }
  
  }


}
