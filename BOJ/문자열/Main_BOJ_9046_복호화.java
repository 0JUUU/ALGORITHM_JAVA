import java.io.*;

/**
 * BOJ 9046 복호화
 * 2021.12.07
 * : 알파벳 빈도수 체크 
 * @author 0JUUU
 *
 */
public class Main_BOJ_9046_복호화 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc<T; tc++) {
			char ans = '0';
			String cipher = br.readLine();
			int[] alpha = new int[26];
			
			int max = 0, maxIndex = 0;
			for(int i = 0, len = cipher.length(); i < len; i++) {
				if(cipher.charAt(i) == ' ') continue;
				int index = cipher.charAt(i) - 'a';
				alpha[index]++;
				if(max < alpha[index]) {
					max = alpha[index];
					maxIndex = index;
				}
			}
			
			boolean isSameCount = false;
			for(int i = 25; i >= 0; i--) {
				if(max == alpha[i] && maxIndex != i) {
					isSameCount = true;
					break;
				}
			}
			
			if(isSameCount) ans = '?';
			else ans = (char) ('a' + maxIndex);
			sb.append(ans + "\n");
		}
		
		System.out.print(sb);
	}
}
