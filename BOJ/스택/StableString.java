import java.util.*;
import java.util.Stack;
import java.io.*;

/***
 *  BOJ 4889. 안정적인 문자열
 *  2021.01.26 
 *  SSAFY 스터디
 *  출력양식을 잘지키자
 * @author clleo
 *
 */
public class StableString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = 1;
		while(true) {
			String s = br.readLine();
			int answer = 0;
			if(s.contains("-")) break;
			Stack<Character> stack = new Stack<>();
			for(int i = 0;i<s.length();i++) {
				if(s.charAt(i) == '{') {
					stack.push(s.charAt(i));
				}
				else if(s.charAt(i) == '}'){
					if(!stack.empty() && stack.peek() == '{') { 
						stack.pop();
					}
					else stack.push(s.charAt(i));
				}
			}
			int leftside = 0; int rightside = 0;
			
			if(stack.empty()) answer = 0;
			else {
				for(int i = 0;i<stack.size();i++) {
					if(stack.elementAt(i) == '{') {
						leftside++;
					}
					else rightside++;
				}
				answer = rightside/2 + rightside%2 + leftside/2+leftside%2;
			}
			bw.write(tc+". "+answer+"\n");		// 출력 양식 잘지키기
			tc++;
		}
		bw.flush();
		bw.close();
	}
}