import java.io.*;
import java.util.*;

// 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
// 설명

// 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

// 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

// 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


// 입력

// 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


// 출력

// 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.


// 예시 입력 1 

// 6
// 50 2
// 20 1
// 40 2
// 60 3
// 30 3
// 30 1
// 예시 출력 1

// 150


public class Main {

  static long n, ret;
  static PriorityQueue<Lecture> pq = new PriorityQueue<>();

  static class Lecture implements Comparable<Lecture> {
    long m, d;

    public Lecture(long m, long d){
      this.m = m;
      this.d = d;
    }

    @Override
    public int compareTo(Lecture l) {
      return this.d - l.d == 0 ? (int)(l.m - this.m) : (int)(this.d - l.d);
    }
  }

  static PriorityQueue<Long> ans = new PriorityQueue<>();
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    for (int i = 0 ; i <  n ;i++) { 
      StringTokenizer st = new StringTokenizer(br.readLine());

      int m, d;
      m = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());

      pq.offer(new Lecture(m, d));
    }

    while(!pq.isEmpty()) {
      
    if (ans.isEmpty()) {
      Lecture l = pq.poll();
      ans.offer(l.m);
    }
    else {
      Lecture cur_l = pq.poll();
      if (ans.size() >= cur_l.d) {
        if (ans.peek() < cur_l.m) {
          ans.poll();
          ans.offer(cur_l.m);
        }
      }
      else {
        ans.offer(cur_l.m);
      }
    }

  }
  for (long i: ans){
    ret += i;
  }
  System.out.println(ret);
}
}
