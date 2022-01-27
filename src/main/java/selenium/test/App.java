package selenium.test;

import java.util.*;

public class App {
  public static void main(String[] args) {
	  String s = "jdwgvbjabcdhdgvefghi";
	  
	  int count = 0;
	  int max = 0;
	  
	  String maxStr = "";
	  String currStr = "";
	  
	  char prevChar = s.charAt(0);
	  
	  for (int i = 1; i < s.length(); i++) {
		  if ((int)s.charAt(i) - prevChar == 1) {
			  count++;
			  currStr = currStr + s.charAt(i);
		  }
		  else {
			  if (count > max) {
				  max = count;
				  maxStr = currStr;
				  count = 0;
				  currStr = "";
			  }
		  }
		  prevChar = s.charAt(i);
		  System.out.println(currStr);
	  }
	  
	  System.out.println(max);
	  System.out.println(maxStr);
  }
}
