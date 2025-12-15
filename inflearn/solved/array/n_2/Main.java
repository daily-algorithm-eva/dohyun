import java.io.*;
import java.util.*;

// 설명

// 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

// 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


// 입력

// 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


// 출력

// 선생님이 볼 수 있는 최대학생수를 출력한다.

// 스택을 활용하면 간단히 풀 문제 같은데, 강의 단계인 배열에 충실하려고 배열 활용했습니다.
public class Main {
  public static void main(String[] args) throws IOException {
    int n, ret, cur_top;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    n = Integer.parseInt(br.readLine());
    ret = 1;
    int arr[] = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    cur_top = arr[0];
    for (int cur: arr) {
      if (cur > cur_top) {
        cur_top = cur;
        ret++;
      }
    }
    System.out.println(ret);
  }
}
