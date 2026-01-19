package inflearn.solved.string.n_10.my;
import java.util.*;
import java.io.*;

// 설명

// 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


// 입력

// 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

// 문자열의 길이는 100을 넘지 않는다.


// 출력

// 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    List<Integer> index = new ArrayList<>();
    int[] ret = new int[101];

    char[] arr = st.nextToken().toCharArray();
    char find = st.nextToken().charAt(0);

    for (int i = 0; i < arr.length; i++) {
      ret[i] = 999;
      if (find == arr[i]) {
        index.add(i);
      }
    }

    for (int i = 0; i < index.size(); i++) {
      for (int j = 0; j < arr.length; j++) {
        ret[j] = Math.min(ret[j], Math.abs(index.get(i)-j)); 
      }
    }
      
  for (int i = 0; i < arr.length; i++) {
    System.out.print(ret[i] + " ");
  }
  }

}
