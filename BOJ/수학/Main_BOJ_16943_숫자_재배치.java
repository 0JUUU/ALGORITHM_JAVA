import java.util.*;
import java.io.*;

/**
 * BOJ 16943 숫자 재배치
 * 2021.10.28
 * : A < B / A > B / A == B일 경우를 나눠서 생각
 * A == B 일 때 안되는 경우에 대한 예외처리를 안해줬었음 (e.g. 0090 1900)
 * 예외에 신경쓰자
 * @author 0JUUU
 *
 */

public class Main_BOJ_16943_숫자_재배치 {

	static String A, B, C;
	static int lenA, lenB;
	static boolean[] used;
	static char[] selected, arrA;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		C = "0";
		lenA = A.length();
		lenB = B.length();
		if(lenA > lenB) {	// 길이 짧을 때
			System.out.println(-1);
			return;
		}
		arrA = A.toCharArray();
		
		
		if(lenA < lenB) {	// A가 B보다 길이 짧으면 => 무적권
			Arrays.sort(arrA);
			StringBuilder sb = new StringBuilder();
			for(int i = lenA-1; i>=0; i--) {
				sb.append(arrA[i]);
			}
			System.out.println(sb);
			return;
		}
		Arrays.sort(arrA);
		String smallA = new String(arrA);
		if(smallA.compareTo(B) >= 0) {
			System.out.println(-1);
			return;
		}
		
		used = new boolean[lenA];
		selected = new char[lenA];
		arrA = A.toCharArray();
		perm(0);
		if(C.equals("0")) System.out.println(-1);
		else System.out.println(C);
	}
	private static void perm(int cnt) {
		if(cnt == lenA) {
			if(selected[0] == '0') return;
			String tmp = new String(selected);
			if(tmp.compareTo(B) < 0) {
				C = tmp.compareTo(C) > 0 ? tmp : C;
			}
 			return;
		}
		
		for(int i = 0; i<lenA; i++) {
			if(used[i]) continue;
			used[i] = true;
			selected[cnt] = arrA[i];
			perm(cnt+1);
			used[i] = false;
		}
	}
}
