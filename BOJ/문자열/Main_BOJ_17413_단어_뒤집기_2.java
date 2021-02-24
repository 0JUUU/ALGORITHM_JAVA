import java.util.*;
import java.io.*;

/**
 * BOJ 17413 단어 뒤집기 2
 * 2021.02.22
 * @author 0JUUU
 *
 */
public class Main_BOJ_17413_단어_뒤집기_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean isTag = false;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb_tag = new StringBuilder();
		StringBuilder sb_reverse = new StringBuilder();
		
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) == '<') {	// 태그 처리
				isTag = true;
				sb.append(sb_reverse.reverse());
				sb_reverse = new StringBuilder();
				sb_tag.append(s.charAt(i));
			} else if(isTag) {
				sb_tag.append(s.charAt(i));
				if(s.charAt(i) == '>') {
					isTag = false;
					sb.append(sb_tag);
					sb_tag = new StringBuilder();
				}
			} else if(s.charAt(i) == ' ') {
				sb.append(sb_reverse.reverse());
				sb.append(' ');
				sb_reverse =  new StringBuilder();
			} else {
				sb_reverse.append(s.charAt(i));
			}
		}
		sb.append(sb_reverse.reverse());
		System.out.println(sb);
	}
}
