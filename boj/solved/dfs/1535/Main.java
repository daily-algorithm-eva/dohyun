import java.util.*;
import java.io.*;

public class Main {
  
  static int n, ret;
  static int[] hp, joy;

  static void solve (int cur_hp, int cur_joy, int idx) {

    if(cur_hp >= 100) {
      return;
    }

    if (idx == n) {
      ret = Math.max(ret, cur_joy);
      return;
    }

    solve(cur_hp + hp[idx], cur_joy + joy[idx], idx + 1);
    solve(cur_hp, cur_joy, idx + 1) ;

  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());
    hp = new int[n];
    joy = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) { 
      hp[i] = Integer.parseInt(st.nextToken());
    }


    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) { 
      joy[i] = Integer.parseInt(st.nextToken());
    }

    solve(0, 0, 0);

    System.out.println(ret);
  }
}
