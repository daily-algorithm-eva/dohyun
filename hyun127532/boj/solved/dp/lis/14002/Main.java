import java.util.*;
import java.io.*;

public class Main {

    static int n, len;
    static int[] arr, dp, idx;

    static int lowerBound(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (dp[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        idx = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(0, len, arr[i]);
            dp[pos] = arr[i];
            idx[i] = pos;
            if (pos == len) len++;
        }

        System.out.println(len);

        Stack<Integer> stack = new Stack<>();
        int target = len - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (idx[i] == target) {
                stack.push(arr[i]);
                target--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
