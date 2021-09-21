import java.util.*;
import java.io.*;

/**
 * BOJ 1622 공통 순열
 * 2021.09.21
 * 1. EOF 처리
 * 2. LCS 구하기 => LCS 구하는게 아니고 그냥 부분 수열 구하는 것임
 * @author 0JUUU
 *
 */
public class Main_BOJ_1622_공통_순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = "", b = "";
		while((a = br.readLine()) != null) {
			b = br.readLine();
			int aLen = a.length();
			int bLen = b.length();
			int[] aCount = new int[26];
			int[] bCount = new int[26];
			int[] total = new int[26];
			for(int i = 0; i < aLen; i++) {
				aCount[a.charAt(i) - 'a']++;
			}
			for(int i = 0; i < bLen; i++) {
				bCount[b.charAt(i) - 'a']++;
			}
			
			for(int i = 0; i < 26; i++) {
				char alpha = (char) (i + 'a');
				int small = Math.min(aCount[i], bCount[i]);
				for(int j = 0; j < small; j++) {
					sb.append(alpha);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
