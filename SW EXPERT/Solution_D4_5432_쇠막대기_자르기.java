import java.util.*;
import java.io.*;

public class Solution_D4_5432_쇠막대기_자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			String s= br.readLine(); 	// 얘를 char[] ch = br.readLine().toCharArray();
 			Stack<Character> laser = new Stack<>();
			Stack<Character> stick = new Stack<>();
			int ans = 0;
			
			for(int i = 0;i<s.length();i++) {
				if(s.charAt(i) == '(') {
					if(s.charAt(i+1) == ')') {	// --> 바로 다음이 닫는 괄호라면 레이저라는 의미
						laser.add(s.charAt(i));
					} else {	// 닫는 괄호가 아닌 경우 --> 막대기라는 의미
						stick.add(s.charAt(i));
					}
					
				} else {	// s.charAt(i) == ')'
					if(!laser.isEmpty()) {	// 현재 s.charAt(i)는 레이저라는 의미
						laser.pop();
						ans += stick.size();
					}
					else {	// 막대기가 끝났다는 의미
						stick.pop();
						ans += 1;
					}
				}
			} // 입력한 문자열 s for문
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} // for - 테케
		System.out.println(sb);
	}	// main
}
