import java.util.*;
import java.io.*;

// 설명

// 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

// 입력
// 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
// 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
// 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
// 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
// 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

// 출력
// 오름차순으로 정렬된 배열을 출력합니다.


public class Main {
  
  static int n, m, idx_n, idx_m;
  static int[] arr_n, arr_m, arr_ret;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    arr_n = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i ++) {
      arr_n[i] = Integer.parseInt(st.nextToken());
    }

    m = Integer.parseInt(br.readLine());
    arr_m = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i ++) {
      arr_m[i] = Integer.parseInt(st.nextToken());
    }

    arr_ret = new int[m+n];

    int i = 0;
    while (idx_n < n && idx_m < m) {
      if (arr_n[idx_n] < arr_m[idx_m]) {
        arr_ret[i] = arr_n[idx_n++];
      }
      else {
        arr_ret[i] = arr_m[idx_m++];
      }
      i++;
    }

    while (idx_n < n) {
      arr_ret[i] = arr_n[idx_n++]; 
      i++;
    }


    while (idx_m < m) {
      arr_ret[i] = arr_m[idx_m++]; 
      i++;
    }

    for (int ret: arr_ret) {
      System.out.print(ret + " ");
    }
  }
}
