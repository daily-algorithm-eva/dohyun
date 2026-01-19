import java.util.*;
import java.io.*;
// 4. 가장 높은 탑 쌓기
// 설명

// 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.

// 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.

// (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.

// (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.

// (조건3) 벽돌들의 높이는 같을 수도 있다.

// (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.

// (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.


// 입력

// 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.

// 둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.

// 각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.


// 출력

// 첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.


// 예시 입력 1 

// 5
// 25 3 4
// 4 4 6
// 9 2 3
// 16 2 5
// 1 5 2

// 예시 출력 1

// 10
public class Main {

  static int n;
  static Block[] arr;
  static int[] dp;

  static class Block {
    int width, height, weight;

    Block (int width, int height, int weight) {
      this.width = width;
      this.height = height;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    dp = new int[n];
    arr = new Block[n];

    for (int i = 0; i < n; i ++) {
      st = new StringTokenizer(br.readLine());
      int width, height, weight;
      width = Integer.parseInt(st.nextToken());
      height = Integer.parseInt(st.nextToken());
      weight = Integer.parseInt(st.nextToken());

      arr[i] = new Block(width, height, weight);
    }
    
    Arrays.sort(arr, (a, b) -> b.width - a.width);

    for (int i = 0; i < n; i++) {
      int _max = 0;
      for (int j = i - 1; j>= 0; j--) {
        int under = arr[j].width;
        int weight = arr[j].weight;
        if (arr[i].width < under && arr[i].weight < weight && dp[j] > _max) {
          _max = dp[j];
        }
      }
        dp[i] = _max + arr[i].height;
    }

      int ret = Integer.MIN_VALUE;
      for (int i : dp) {
        ret = Math.max(i, ret);
      }

      System.out.println(ret);

  }
}
