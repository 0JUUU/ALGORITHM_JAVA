import java.util.*;
import java.io.*;

/**
 * BOJ 1283 단축키 지정
 * 2021.05.06
 * 하나하나 다 해봄 
 * @author 0JUUU
 *
 */
public class Main_BOJ_1283_단축키_지정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];	// 대소문자 구분 X
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i<N;i++) {
			String s = br.readLine();
			ArrayList<String> words = new ArrayList<>();
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()) {
				words.add(st.nextToken());
			}
			int cnt = 0, size = words.size();
			boolean foundFirst = false;
			while(cnt != size) {	// 각 단어의 첫글자가 단축키인지 확인
				String word = words.get(cnt);
				int alphabet = word.charAt(0) - 'a' >= 0 ? word.charAt(0) - 'a' : word.charAt(0) - 'A';
				if(alpha[alphabet] == 0) {
					alpha[alphabet] = 1;
					String tmp;
					tmp = "";
					tmp+= "[";
					tmp += word.substring(0, 1);
					tmp += "]";
					tmp += word.substring(1);
					words.add(cnt, tmp);
					words.remove(cnt+1);
					foundFirst = true;
					break;
				}
				cnt++;
			}
			
			cnt = 0;
			if(!foundFirst) {
				while(cnt != size) {	// 각 단어의 첫글자가 단축키인지 확인
					String word = words.get(cnt);
					int alphabet;
					boolean isFind = false;
					for(int w = 1; w<word.length();w++) {
						alphabet = word.charAt(w) - 'a' >= 0 ? word.charAt(w) - 'a' : word.charAt(w) - 'A';
						if(alpha[alphabet] == 0) {
							alpha[alphabet] = 1;
							String tmp;
							tmp = "";
							tmp += word.substring(0, w);
							tmp+= "[";
							tmp += word.charAt(w);
							tmp += "]";
							tmp += word.substring(w+1);
							words.add(cnt, tmp);
							words.remove(cnt+1);
							isFind = true;
							break;
						}
					}
					if(isFind) break;
					cnt++;
					
				}
			}
			
			s = new String();
			for (String string : words) {
				s += string;
				s += " ";
			}
			s = s.substring(0, s.length()-1);
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}
