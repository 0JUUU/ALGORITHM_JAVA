import java.util.*;
import java.util.Stack;
import java.io.*;

/**
 * BOJ 4949. 균형잡힌 세상
 * 2021.01.25
 * SSAFY 스터디
 * @author clleo
 *
 */
public class WorldInBalance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			if(s.equals(".")) break;
			String answer = "yes";
			for(int i = 0;i<s.length();i++) {
				if(s.charAt(i) == '[' || s.charAt(i) == '(') stack.push(s.charAt(i));
				else if (s.charAt(i) == ']'){
					if(stack.empty()) {
						answer = "no"; break;
					}
					
					if(stack.peek() == '[') stack.pop();
					else {
						answer = "no"; break;
					}
				}
				else if(s.charAt(i) == ')') {
					if(stack.empty()) {
						answer = "no"; break;
					}
					if(stack.peek() == '(') stack.pop();
					else {
						answer = "no"; break;
					}
				}
			}
			if(stack.size() != 0) answer = "no";
			bw.write(answer + "\n");
		}
		bw.flush(); bw.close();
	}
}
