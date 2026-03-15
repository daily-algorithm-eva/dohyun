import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int before_correct = 0;
    int ret = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
  
    while(st.hasMoreTokens()) {
      if (st.nextToken().equals("1")) {
        before_correct++;
        ret++;
      }
      else {
        while (before_correct > 0) {
            before_correct--;
            ret += before_correct;
          }
        }
      }
    while (before_correct > 0) {
            before_correct--;
            ret += before_correct;
          }

      System.out.println(ret);
    
  }
}
