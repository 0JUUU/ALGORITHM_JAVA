import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호_짝짓기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			String s = br.readLine();
			char[] string = new char[s.length()];
			Stack<Character> stack = new Stack<>();
			boolean isPair = true;
			for (int i = 0; i < s.length(); i++) {
				string[i] = s.charAt(i);
				switch (string[i]) {
				case '(':
					stack.add('(');
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						isPair = false;
						break;
					}
					stack.pop();
					break;
				case '{':
					stack.add('{');
					break;
				case '}':
					if (stack.isEmpty() || stack.peek() != '{') {
						isPair = false;
						break;
					}
					stack.pop();
					break;
				case '[':
					stack.add('[');
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						isPair = false;
						break;
					}
					stack.pop();
					break;
				case '<':
					stack.add('<');
					break;
				case '>':
					if (stack.isEmpty() || stack.peek() != '<') {
						isPair = false;
						break;
					}
					stack.pop();
					break;
				}
				if (!isPair)
					break;
			}

			if (!isPair) {
				System.out.println("#" + tc + " " + 0);
			} else {
				System.out.println("#" + tc + " " +1);
			}
		}
	}
}
