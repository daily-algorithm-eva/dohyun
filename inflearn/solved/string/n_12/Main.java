import java.util.*;
import java.io.*;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder ret = new StringBuilder();

    StringBuilder tmp = new StringBuilder();

    String num = br.readLine();
    String str = br.readLine();

    

    int idx = 0;
    for (int i = 0; i < str.length(); i++) {
      idx++;

      if (str.charAt(i) == '#') 
        tmp.append('1');
      else 
        tmp.append('0');

      if (idx == 7) {
        idx = 0;
        ret.append((char)Integer.parseInt(tmp.toString(), 2));
        tmp.setLength(0);
        
      }
    }

    System.out.println(ret);
  }
}
