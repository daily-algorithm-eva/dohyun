import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();

    String str = br.readLine().toLowerCase();

    int l = 0;
    int r = str.length() - 1;

    while(l < r) {
      if (str.charAt(l) != str.charAt(r)) {
        System.out.println("NO");
        return;
      }
      l++;
      r--;
    }
    System.out.println("YES");
  }
}
