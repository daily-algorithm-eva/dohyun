import java.util.*;
import java.io.*;


/*
설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

입력

첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

출력

자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

*/

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();

    int n, cur, next;
    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    cur = Integer.parseInt(st.nextToken());
    next = Integer.parseInt(st.nextToken());
    sb.append(cur);
    sb.append(' ');

    for (int i = 2; i < n; i++){
      if (cur < next) {
        sb.append(next);
        sb.append(' ');
      }
      cur = next;
      next = Integer.parseInt(st.nextToken());
    } 

    if (cur < next) {
      sb.append(next);
    }
    System.out.println(sb);
  } 
}
