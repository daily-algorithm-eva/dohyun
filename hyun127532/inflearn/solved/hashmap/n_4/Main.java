import java.util.*;
import java.io.*;

// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

// 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


// 입력

// 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

// S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


// 출력

// S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


// 예시 입력 1 

// bacaAacba
// abc
// 예시 출력 1

// 3


public class Main {
  static char[] s, t;
  static int ret, tmp, lt, rt;
  static HashMap<Character, Integer> map_s = new HashMap<>();  
  static HashMap<Character, Integer> map_t = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    s = br.readLine().toCharArray();
    t = br.readLine().toCharArray();

    for (int i = 0; i < t.length; i++) {
      map_t.put(t[i], map_t.getOrDefault(t[i], 0) + 1 );
      map_s.put(s[i], map_s.getOrDefault(s[i], 0) + 1);
    }

     if (map_s.equals(map_t)) ret++;

    for (int rt = t.length; rt < s.length; rt++) {
      tmp = 1;

      map_s.put(s[lt], map_s.get(s[lt]) - 1);
      map_s.put(s[rt], map_s.getOrDefault(s[rt], 0) +1);
      lt++;

      for (int i = 0; i < t.length; i++) {
        if (map_t.get(s[lt + i]) != map_s.get(s[lt + i])) {
          tmp = 0;
        }
      }
      if (tmp == 1) {
        ret++;
      }
  
    }



    System.out.println(ret);
  }

}
