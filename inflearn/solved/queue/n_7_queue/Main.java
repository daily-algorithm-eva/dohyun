import java.util.*;
import java.io.*;


public class Main {
  
  static Queue<Character> q = new LinkedList<>();
  static char[] essential, plan;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    essential = br.readLine().toCharArray();
    plan = br.readLine().toCharArray();

    for (char ch: essential) {
      q.offer(ch);
    }

    for (int i = 0; i < plan.length; i++) {
      if(q.contains(plan[i]) && q.peek() == plan[i]) {
        q.poll();
      }
    }

    if (q.isEmpty()) {
      System.out.println("YES");
      return;
    }

    System.out.println("NO");
  }
}
