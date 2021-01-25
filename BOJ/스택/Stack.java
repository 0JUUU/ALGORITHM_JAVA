import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10828. 스택
 * 2021.01.25
 * @author clleo
 *
 */

public class Stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_Stack.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = 0;
		int[] stack = new int[100001];
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			String s = br.readLine();
			String[] token = s.split(" ");
			if(token.length == 2) {	// push X
				stack[size++] = Integer.parseInt(token[1]);
			}
			else {
				switch(s) {
				case "pop" : 
					if(size == 0) System.out.println(-1);
					else {
						System.out.println(stack[size-1]);
						size--;
					}
						break;
				case "size" :
					System.out.println(size);
					break;
				case "empty": 
					if(size == 0) System.out.println(1);
					else System.out.println(0);
					break;
				case "top":
					if(size == 0) System.out.println(-1);
					else System.out.println(stack[size-1]);
					break;
				default:
				}
			}
		}
	}
}
