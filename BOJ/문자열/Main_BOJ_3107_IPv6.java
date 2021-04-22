import java.util.*;
import java.io.*;

/**
 * BOJ 3107 IPv6
 * 2021.04.22
 * @author 0JUUU
 *
 */
public class Main_BOJ_3107_IPv6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] addr = new String[8];
		String[] shortStr = new String[8];
		int[] shortLen = new int[8];
		for (int i = 0; i < 8; i++) {
			addr[i] = "0000";
		}
		String s = br.readLine();

		StringTokenizer st = new StringTokenizer(s, ":");
		int count = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			shortStr[count] = token;
			shortLen[count++] = token.length();
		}
		if (count == 8) {

			for (int i = 0; i < 8; i++) {
				addr[i] += shortStr[i];
			}

			for (int i = 0; i < 8; i++) {
				addr[i] = addr[i].substring(shortLen[i], addr[i].length());
			}
			for (int i = 0; i < 8; i++) {
				sb.append(addr[i] + ":");
			}
			sb.setLength(sb.length() - 1);

		} else {
			int left = 0, right = 7;
			int startCol = 0, endCol = 7;
			// 앞부터
			for(int i = 0; i<s.length();i++) {
				if(i == 0 && s.charAt(i) == ':') {
					break;
				} else if(s.charAt(i) == ':' && s.charAt(i+1) == ':') {
					startCol++;
					left = startCol;
					break;
				} else if(s.charAt(i) == ':') {
					startCol++;
				}
			}
			
			// 뒤부터
			for(int i = s.length()-1; i>=0;i--) {
				if(i == s.length()-1 && s.charAt(i) == ':') {
					break;
				} else if(s.charAt(i) == ':' && s.charAt(i-1) == ':') {
					endCol--;
					right = endCol;
					break;
				} else if(s.charAt(i) == ':') {
					endCol--;
				}
			}
			
			for(int i = 0; i<left;i++) {
				addr[i] += shortStr[i];
			}
			
			int index = left;
			for(int i = right+1; i<8;i++) {
				addr[i] += shortStr[index++];
			}
			
			for (int i = 0; i < 8; i++) {
				addr[i] = addr[i].substring(addr[i].length()-4, addr[i].length());
			}
			for (int i = 0; i < 8; i++) {
				sb.append(addr[i] + ":");
			}
			sb.setLength(sb.length() - 1);
		}

		System.out.println(sb);
	}
}
