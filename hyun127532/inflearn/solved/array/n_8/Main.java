import java.util.*;
import java.io.*;


// 설명

// N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

// 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

// 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


// 입력

// 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


// 출력

// 입력된 순서대로 등수를 출력한다.



public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    Integer[] arr = new Integer[n];
    Integer[] grade = new Integer[101];
    Integer[] arr_sort = new Integer[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      arr_sort[i] = arr[i];
  
    }
    Arrays.sort(arr_sort, Collections.reverseOrder());
    
    for (int i = 0; i < n; i++) {
      if (grade[arr_sort[i]] == null) {
         grade[arr_sort[i]] = i + 1;
      }
    }

    for (int i :arr) {
      System.out.print(grade[i] + " ");
    }

  }
}
