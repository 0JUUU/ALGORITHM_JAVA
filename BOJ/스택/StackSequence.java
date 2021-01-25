import java.util.*;
import java.util.Stack;
import java.io.*;

/**
 * BOJ 1874. 스택 수열
 * 2021.01.25
 * SSAFY 스터디
 * StringBuffer
 * @author clleo
 *
 */
public class StackSequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int[] sequence = new int[n];
		Stack<Integer> num = new Stack<>();
 		for(int i = 0;i<n;i++) {
 			sequence[i] = Integer.parseInt(br.readLine());
 			num.push(n-i);
 		}
 		boolean isOk = true;
 		for(int i = 0;i<n;) {
 			if(stack.empty()) {
 				stack.push(num.peek());
 				num.pop();
 			}
 				
 			if(stack.peek() == sequence[i]) {
 				stack.pop(); i++;
 			}
 			while(!stack.empty() && stack.peek() != sequence[i]) {
 				if(num.empty()) break;
 				stack.push(num.peek()); num.pop();
 				
 			}
 			if(!stack.empty() && stack.peek() > sequence[i]) {
 				isOk = false;
 				break;
 			}
 				
 		}
 		if(!isOk) System.out.println("NO");
 		else {
 			for(int i = 0;i<n;i++) {
 	 			num.push(n-i);
 	 		}
 	 		for(int i = 0;i<n;) {
 	 			if(stack.empty()) {
 	 				stack.push(num.peek()); System.out.println("+");
 	 				num.pop();
 	 			}
 	 				
 	 			if(stack.peek() == sequence[i]) {
 	 				stack.pop(); i++; System.out.println("-");
 	 			}
 	 			while(!stack.empty() && stack.peek() != sequence[i]) {
 	 				if(num.empty()) break;
 	 				stack.push(num.peek()); System.out.println("+");num.pop();
 	 				
 	 			}
 	 				
 	 		}
 		}
 			
	}
}
