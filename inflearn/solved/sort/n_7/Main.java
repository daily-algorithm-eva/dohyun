import java.util.*;
import java.io.*;

// 7. 좌표 정렬
// 설명

// N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.

// 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.


// 입력

// 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.

// 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.


// 출력

// N개의 좌표를 정렬하여 출력하세요.


// 예시 입력 1 

// 5
// 2 7
// 1 3
// 1 2
// 2 5
// 3 6
// 예시 출력 1

// 1 2
// 1 3
// 2 5
// 2 7
// 3 6

public class Main {

  static class Coordinate implements Comparable<Coordinate> {
    int x, y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Coordinate c) {
      return this.x - c.x == 0 ? this.y - c.y : this.x - c.x;
    }
  }

 static int n, x, y;
 static PriorityQueue<Coordinate> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    
    for (int i = 0 ; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      pq.offer(new Coordinate(x, y));
    }

    for (int i = 0; i < n; i++) {
      Coordinate c = pq.poll();
      System.out.println(c.x + " " + c.y);
    }

    
  }
  
}
