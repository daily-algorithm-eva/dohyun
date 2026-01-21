import java.util.*;
import java.io.*;

public class Main {
  static int n, k, level;
  static int[] visited;
  static int[] dx = {-1, 1};
  static Deque<Integer> dq = new ArrayDeque<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    visited = new int[100001];

    Arrays.fill(visited, Integer.MAX_VALUE);

    dq.offer(n);
    visited[n] = 0;

    while (!dq.isEmpty()) {
      int cur = dq.poll();

      if (cur == k) {
        System.out.println(visited[cur]);
        break;
      }

      if (cur * 2 < 100001 && visited[cur * 2] > visited[cur]) {
        visited[cur * 2] = visited[cur];
        dq.offerFirst(cur * 2);
      }

      for (int i = 0; i < 2; i++) {
        int nx = cur + dx[i];
        if (nx >= 0 && nx < 100001 && visited[nx] > visited[cur]+1) {
          visited[nx] = visited[cur] + 1;
          dq.offerLast(nx);
        }
      }
    }
    
  }
}
