import java.util.*;
import java.io.*;

/**
 * BOJ 16637 괄호 추가하기
 * 2021.03.11 --> 2021.04.11
 * : 음수값이 나올 수 있으므로 max는 음수로 설정해야 한다.
 * : 곱하기가 없다면 그대로 진행하는 것이 최대값이라고 생각했는데 그것은 잘못된 생각 ㅎㅎ
 * @author 0JUUU
 *
 */
public class Main_BOJ_16637_괄호_추가하기 {
	static int N, count_mul, max = Integer.MIN_VALUE;
	static String s;
	static boolean isVisited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = br.readLine();
		
		makeBracket(1, s.charAt(0) - '0');
		System.out.println(max);
	}
	
	private static void makeBracket(int index, int curResult) {
		if(index >= N) {
			max =  max < curResult ? curResult : max;
			return;
		}
		
		// 괄호 X
		int tmp = cal(curResult, s.charAt(index), s.charAt(index+1) - '0');
		makeBracket(index + 2, tmp);
		
		// 괄호 O
		if(index + 4 <= N) {
			int makeBra = cal(s.charAt(index+1)-'0', s.charAt(index+2) , s.charAt(index+3)-'0');
			tmp = cal(curResult, s.charAt(index), makeBra);
			makeBracket(index+4, tmp);
		}
	}
	
	private static int cal(int op1, char operator, int op2) {
		switch(operator) {
		case '*':
			return (op1 * op2);
		case '+':
			return (op1 + op2);
		case '-':
			return (op1 - op2);
		}
		return 0;
	}
}
