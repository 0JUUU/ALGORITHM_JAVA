import java.util.*;
import java.io.*;

/**
 * BOJ 1062 가르침 
 * 2021.04.07
 * : replace 는 시간이 굉장히 오래 걸린다. 문자열을 조정할 때는 알파벳 인덱스로 가능하다면 최대한 그것을 활용하자.
 * @author 0JUUU
 *
 */
public class Main_BOJ_1062_가르침 {
	static int N, K, max = Integer.MIN_VALUE, size;
	static String[] words;
	static String[] necessary = {"a","c","i","n","t"};
	static int[] alphabet = new int[26];
	static int[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		int count = 0;
		for(int i = 0; i<N;i++) {
			words[i] = br.readLine();
			for(int n = 0; n<5;n++) {
				words[i] = words[i].replace(necessary[n], "");
			}
			for(int s = 0, size = words[i].length(); s<size;s++) {
				if(alphabet[words[i].charAt(s) -'a'] == 0) {
					count++; alphabet[words[i].charAt(s)-'a'] = 1;
				}
			}
		}
		
		if(K < 5) System.out.println(0);
		else if(K == 26) System.out.println(N);
		else if(K - 5 >= count) System.out.println(N);
		else if(K == 5) {
			count = 0;
			for(int i = 0; i<N;i++) {
				if(words[i].equals("")) count++;
			}
			System.out.println(count);
		} else {
			selected = new int[26];
			comb(0, 0);
			System.out.println(max);
		}
	}
	
	private static void comb(int cnt, int start) {
		if(max == N) return;
		if(cnt == K-5) {
			int word = 0;
			for(int i = 0; i<N;i++) {
				boolean avail = true;
				for(int j = 0; j<words[i].length();j++) {
					if(selected[words[i].charAt(j) -'a'] == 0) {
						avail = false;
						break;
					}
				}
				if(avail) word++;
			}
			max = max < word ? word : max;
			return;
		}
		for(int i = start; i<26;i++) {
			if(alphabet[i] == 0) continue;
			selected[i] = 1;
			comb(cnt+1, i+1);
			selected[i] = 0;
			if(max == N) return;
		}
	}
}
