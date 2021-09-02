import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main_BOJ_3613_Java_vs_Cpp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String var = br.readLine();
		int len = var.length();
		if(var.contains("_")) {
			if(var.matches(".*[A-Z].*")) {
				System.out.println("Error!");
				return;
			} else if(var.charAt(0) == '_' || var.charAt(len - 1) == '_') {
				System.out.println("Error!");
				return;
			} else if(var.contains("__")) {
				System.out.println("Error!");
				return;
			}
			while(var.contains("_")) {
				char change;
				int index = var.indexOf('_');
				change = (char) ('A' + (var.charAt(index+1) - 'a'));
				var = var.substring(0, index) + change + var.substring(index+2, len);
				len = var.length();
			}
			System.out.println(var);
			return;
		} else {
			if(var.charAt(0) >= 'A' && 'Z' >= var.charAt(0)) {
				System.out.println("Error!");
				return;
			}
			while(var.matches(".*[A-Z].*")) {
				char change;
				int index = -1;
				for(int i = 0; i<len;i++) {
					if(var.charAt(i) >= 'A' && 'Z' >= var.charAt(i)) {
						index = i;
						break;
					}
				}
				change = (char) ((var.charAt(index) - 'A') + 'a');
				var = var.substring(0, index) + "_" + change + var.substring(index+1, len);
				len = var.length();
			}
			System.out.println(var);
			return;
		}
			
		
	}
}
