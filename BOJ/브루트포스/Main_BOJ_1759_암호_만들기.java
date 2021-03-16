import java.util.*;
import java.io.*;

/**
 * BOJ 1759 암호 만들기
 * 2021.03.16
 * : 1. 모음의 조합과 자음의 조합을 따로 구해서 합한 후, 정렬을 하였음
 * @author 0JUUU
 *
 */
public class Main_BOJ_1759_암호_만들기 {
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	static LinkedList<Character> vowels = new LinkedList<>();
	static LinkedList<Character> consonants = new LinkedList<>();
	static char[] selectV, selectC;
	static LinkedList<String> answer = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[] avail = new char[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<C;i++) {
			char cur = st.nextToken().charAt(0);
			if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
				vowels.add(cur);
			} else {
				consonants.add(cur);
			}
		}
		Collections.sort(vowels); Collections.sort(consonants);
		
		int countV = 1;
		while(L - countV != 1) {
			selectV = new char[countV];
			selectC = new char[L-countV];
			combination(countV, 0, 0);
			countV++;
		}	
		
		Collections.sort(answer);
		for(int i = 0; i<answer.size();i++) {
			sb.append(answer.get(i)+"\n");
		}
		System.out.println(sb);
	}
	private static void combination(int countV, int cnt, int start) {
		if(cnt == countV) {
			combination2(L - countV, 0, 0);
			return;
		}
		for(int i = start; i<vowels.size();i++) {
			selectV[cnt] = vowels.get(i);
			combination(countV, cnt+1, i+1);
		}
	}
	private static void combination2(int countC, int cnt, int start) {
		if(cnt == countC) {
			String s = "";
			for(int i = 0; i<selectV.length;i++) {
				s += selectV[i];
			}
			for(int i = 0; i<selectC.length;i++) {
				s += selectC[i];
			}
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			s = new String(charArr);
			answer.add(s);
			return;
		}
		for(int i = start; i<consonants.size();i++) {
			selectC[cnt] = consonants.get(i);
			combination2(countC, cnt+1, i+1);
		}
		
	}
}
