import java.util.*;
import java.io.*;

/**
 * BOJ 1918. 후위 표기식
 * 2021.02.08
 * : 1. 처음 풀었던 방식 : 열린 괄호가 등장 --> 괄호가 있음을 표시, 닫힌 괄효 등장 -> 괄호가 없음을 표시 ((A *(B+C) -D)) 와 같이 괄호가 중첩되었을 때, 문제가 발생)
 * ; 2. 괄호가 등장하면, 괄호 안의 것들을 모두 처리한 후 스택에 남이있는 것을 처리하는 방식으로 해결
 * @author 0JUUU
 *
 */
public class Main_BOJ_1918_후위_표기식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		Stack<Character[]> operator = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isFound = false;
		Character[] p = new Character[2];
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) >='A' && s.charAt(i) <= 'Z') {
				sb.append(s.charAt(i));
			} else if(s.charAt(i) == ')') {
				Character[] pair = new Character[2];
				pair = operator.peek();
				while(!operator.isEmpty() && pair[0] != '(') {
					sb.append(pair[0]);
					operator.pop();
					if(!operator.isEmpty())
						pair = operator.peek();
				}
				operator.pop();
			} else if(s.charAt(i) == '(') operator.push(new Character[] {s.charAt(i), '2'});
			else {
				char order = '0';
		
				if(s.charAt(i) == '+' || s.charAt(i) == '-') order = '0';
				else if(s.charAt(i) == '*' || s.charAt(i) == '/') order = '1';
				
				if(!operator.isEmpty()) {
					p = operator.peek();
					while(!operator.isEmpty() && p[1] >= order && p[1] != '2') {
						sb.append(p[0]);
						operator.pop();
						if(!operator.isEmpty())
							p = operator.peek();
					}
				}
				
				operator.push(new Character[] {s.charAt(i), order});
			} 
		} 
		while(!operator.isEmpty()) {
			p = operator.peek();
			sb.append(p[0]);
			operator.pop();
		}
		System.out.println(sb);
	}
}
