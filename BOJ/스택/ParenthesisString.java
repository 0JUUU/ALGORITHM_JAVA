import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.Stack;

/**
 * BOJ 9012. 괄호
 * 2021.01.25
 * SSAFY 스터디
 * "출력 형식에 유의하자"
 * @author 0JUUU
 *
 */
public class ParenthesisString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0;tc<T;tc++) {
			String s = br.readLine();
			String answer = "YES";
			Stack<String> stack = new Stack<>();
			for(int i = 0;i<s.length();i++) {
				if(s.charAt(i) == '(') stack.push("(");
				else {
					if(stack.empty()) {
						answer = "NO";
					}			
					else {
						stack.pop();
					}
				}
			}
			if(stack.size() != 0) answer = "NO";
			bw.write(answer+"\n");
		}//테스트케이스
		bw.flush();
		bw.close();
	}
}
