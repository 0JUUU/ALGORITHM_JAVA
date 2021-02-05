import java.util.*;
import java.io.*;

/**
 * SWEA 1223. 계산기2
 * 2021.02.05
 * : 중위표기식 -> 후위표기식
 * : 1. 연산자를 스택에 넣는 것임, 피연산자는 식에 바로 추가
 * : 2. 연산자에 우선순위를 둬서 우선순위가 같거나 낮은 애들만 내 밑(스택에 먼저)에 있을 수 있도록 함
 *  2-1) 내가 들어갈 턴에 스택의 top이 나보다 우선순위가 높다면 개를 pop하고 식에 추가 언제까지? 나랑 우선순위가 같거나 낮은 애가 나올 때까지~
 *  : 후위표기식으로 표현된 식을 계산
 *  : 1. 후위표시식으로 표현된 식을 앞에서부터 차근차근 처리
 *  : 2. 피연산자를 스택에 넣는 것임, 
 * @author 0JUUU
 *
 */
public class Solution_D4_1223_계산기2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=10;tc++) {
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringBuilder postfix = new StringBuilder();
			Stack<Character> operator = new Stack<>();
			for(int i = 0; i<len;i++) {				// 후위표기식으로 바꾸는 방법
				if(s.charAt(i) == '*') {
					operator.push('*');
				} else if (s.charAt(i) == '+') {
					while(!operator.isEmpty() && operator.peek() == '*') {
						postfix.append(operator.pop());
					}
					operator.push('+');
				} else {	// 0~9까지의 숫자
					postfix.append(s.charAt(i));
				}
			}
			while(!operator.isEmpty()) {
				postfix.append(operator.pop());
			}
			System.out.println(postfix);
			Stack<Integer> operand = new Stack<>();
			int result =0;
			for(int i = 0; i<postfix.length();i++) {
				if('0' <= postfix.charAt(i) && postfix.charAt(i) <= '9') {
					operand.push(postfix.charAt(i) - '0');
				} else {
					int A = operand.pop();
					int B = operand.pop();
					
					if(postfix.charAt(i) == '*') result = A*B;
					else result = A + B;
					operand.push(result);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
