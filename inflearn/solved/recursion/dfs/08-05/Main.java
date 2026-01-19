import java.util.*;
import java.io.*;

// 5. 동전교환
// 설명

// 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

// 각 단위의 동전은 무한정 쓸 수 있다.


// 입력

// 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,

// 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


// 출력

// 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


// 예시 입력 1 

// 3
// 1 2 5
// 15
// 예시 출력 1

// 3
// 힌트



public class Main {
  
  static int n, m, money, ret = 100000000;
  static Integer[] coins;

  static void dfs(int cur_cnt, int cur_money) {
    if(cur_cnt > ret) return;
    if (cur_money > money) return;

    if (cur_money == money) {
      ret = Math.min(ret, cur_cnt);
    }

    for (int i = 0; i < n; i ++) {
      dfs(cur_cnt + 1, cur_money + coins[i]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    coins = new Integer[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    money = Integer.parseInt(br.readLine());

    Arrays.sort(coins, Collections.reverseOrder());
    dfs(0, 0);

    System.out.println(ret);

  }

}
