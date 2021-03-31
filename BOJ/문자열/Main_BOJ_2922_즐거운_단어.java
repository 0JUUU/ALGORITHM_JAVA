import java.util.*;
import java.io.*;

/**
 * BOJ 2922 즐거운 단어
 * 2021.03.31
 * : L이 지정된 후, 다음 자음 자리에 L이 와서 중복이 되는 경우를 생각하지 못함
 * @author 0JUUU
 *
 */
public class Main_BOJ_2922_즐거운_단어 {
	static String input;
	static long count;
	static int length, consonant, vowel, serialC, serialV;
	static ArrayList<Character> vowels = new ArrayList();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		input = br.readLine();
		length = input.length();
		
		if(input.contains("L")) dfs(input, 0);
		else {
			for(int i = 0; i<length;i++) {
				if(input.charAt(i) == '_') {
					String tmp = input.substring(0,i);
					tmp += "L";
					tmp += input.substring(i+1, length);
					dfs(tmp, 0);
					
				}
			}
		}
		System.out.println(count);
	}
	private static void dfs(String input, int index) {
 		if(index == length) {
 			long sum = 0;
			if(serialC < 3 && serialV < 3) {
				long v = (int) Math.pow(5, vowel);
				long c =  (int) Math.pow(21, consonant);
				sum = v*c;
				System.out.println(input);
				System.out.println(sum);
			}
			count += sum;
			return;
		}
		
 		if(serialC == 3 || serialV == 3) return;
		if(input.charAt(index) == '_') {
			int tmp = serialV;
			serialV = 0;
			serialC++; consonant++;
			dfs(input, index+1);
			serialC--; consonant--;
			serialV = tmp;
				
			tmp = serialC;
			serialC = 0;
			serialV++; vowel++;
			dfs(input, index+1);
			serialV--; vowel--;
			serialC = tmp;
		} else {
			if(vowels.contains(input.charAt(index))) {
				int tmp = serialC;
				serialC = 0;
				serialV++;
				dfs(input, index+1);
				serialV--;
				serialC = tmp;
			} else {
				int tmp = serialV;
				serialV = 0;
				serialC++; 
				dfs(input, index+1);
				serialC--;
				serialV = tmp;
			}
		}
	}
}
