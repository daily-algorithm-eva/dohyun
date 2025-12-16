import java.util.*;
import java.io.*;

// 설명

// A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

// 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

// 예를 들어 N=5이면

// Image1.jpg

// 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


// 입력

// 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

// 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

// 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


// 출력

// 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.

public class Main {
  public static void main(String[] args) throws IOException {
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    int arr_a[] = new int[n];
    int arr_b[] = new int[n];
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i ++) {
      arr_a[i] = Integer.parseInt(st_a.nextToken());
      arr_b[i] = Integer.parseInt(st_b.nextToken());
    }

    for (int i = 0; i < n; i++) {
      int result = (arr_a[i] - arr_b[i] + 3) % 3;
      if (result == 0) {
        System.out.println('D');
      }
      else if (result == 1) {
        System.out.println('A');
      }
      else {
        System.out.println('B');
      }
    }
  }
}
