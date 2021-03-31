import java.util.*;
import java.io.*;

/**
 * BOJ 2922 즐거운 단어
 * 2021.03.31
 * : L의 사용여부를 확인할 수 있는 변수를 지정 ---> 해결
 * @author 0JUUU
 *
 */
public class Main_BOJ_2922_즐거운_단어2 {
	static String input;
	static long sum;
	static int length, consonant, vowel, serialC, serialV;
	static boolean isL;
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
		
		if(input.contains("L")) isL = true;
		else {
			isL = false;
		}
		dfs(isL, 1, 0);
		System.out.println(sum);
	}
	private static void dfs(boolean isL, long count, int index) {
 		if(index == length) {
			if(serialC < 3 && serialV < 3 && isL) {
				sum += count;
			}
			return;
		}
		
 		if(serialC == 3 || serialV == 3) return;
		if(input.charAt(index) == '_') {
			int tmp = serialV;
			serialV = 0;
			serialC++;
			dfs(isL,count * 20, index+1);
			dfs(true, count, index + 1);
			serialC--; 
			serialV = tmp;
				
			tmp = serialC;
			serialC = 0;
			serialV++; vowel++;
			dfs(isL,count * 5, index+1);
			serialV--; vowel--;
			serialC = tmp;
		} else {
			if(vowels.contains(input.charAt(index))) {
				int tmp = serialC;
				serialC = 0;
				serialV++;
				dfs(isL,count, index+1);
				serialV--;
				serialC = tmp;
			} else {
				int tmp = serialV;
				serialV = 0;
				serialC++; 
				dfs(isL,count, index+1);
				serialC--;
				serialV = tmp;
			}
		}
	}
}
