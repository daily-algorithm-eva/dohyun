import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int[][] arr;
    static int ret;

    // dir: 0 = 가로, 1 = 세로, 2 = 대각선
    static void dfs(int x, int y, int dir) {
        // 도착
        if (x == n && y == n) {
            ret++;
            return;
        }

        if (dir == 0 || dir == 2) {
            if (y + 1 <= n && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        }

        if (dir == 1 || dir == 2) {
            if (x + 1 <= n && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        }

        if (x + 1 <= n && y + 1 <= n &&
            arr[x][y + 1] == 0 &&
            arr[x + 1][y] == 0 &&
            arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 상태: (1,2), 가로
        dfs(1, 2, 0);

        System.out.println(ret);
    }
}