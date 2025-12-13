import java.util.*;
import java.io.*;


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
