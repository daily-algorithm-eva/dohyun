import java.util.*;
import java.io.*;

public class Main {
  
  static List<Integer> list = new ArrayList<>();

  static void solve(int l, int r) {

    if (l > r) return;

    int root = list.get(l);
    int mid = l + 1;

    while (mid <= r && list.get(mid) < root) {
      mid ++;
    }

    solve(l + 1, mid - 1);
    solve(mid, r);
    System.out.println(root);
  }
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String tmp = br.readLine();
    while(tmp != null && !tmp.isEmpty()) {
      list.add(Integer.parseInt(tmp));
      tmp = br.readLine();
    }

    solve(0, list.size() - 1);
  }
}
