import java.util.*;
import java.io.*;

/**
 * BOJ 2023 신기한 소수
 * 2021.03.16
 * : 1. 에라토스테네스의 체를 이용하여 구함 --> 메모리 초과
 * @author 0JUUU
 *
 */
public class Main_BOJ_2023_신기한_소수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		boolean[] notPrime = new boolean[100000000];
		notPrime[1] = true;
		for(int i = 2; i< (int)Math.pow(10, N);i++) {
			for(int j = 2; i * j <(int)Math.pow(10, N);j++) {
				notPrime[i*j] = true;
			}
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = (int) Math.pow(10, N-1); i<(int)Math.pow(10, N);i++) {
			String s = Integer.toString(i);
			int index = 0;
			while(index != s.length()) {
				if(s.charAt(0) != '2' && s.charAt(0) != '3' && s.charAt(0) != '5' && s.charAt(0) != '7') break;
				else if(index != 0 && s.charAt(index) != '1' && s.charAt(index) != '3' && s.charAt(index) != '5' && s.charAt(index) != '7' && s.charAt(index) != '9') break;
				String sub;
				if(index == 0) {
					sub = Character.toString(s.charAt(0));
				} else {
					 sub = s.substring(0, index+1);
				}
				if(notPrime[Integer.parseInt(sub)]) break;
				if(index == s.length()-1)  
					answer.add(Integer.parseInt(s));
				index++;
			}
		}
		
		for(int i = 0; i<answer.size();i++) {
			sb.append(answer.get(i) + "\n");
		}
		System.out.print(sb);
	}
}
