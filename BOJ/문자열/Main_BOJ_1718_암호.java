import java.util.*;
import java.io.*;

/**
 * BOJ 17178 암호
 * 2021.03.11
 * : 문자열 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_1718_암호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String plain = br.readLine();
		String key = br.readLine();
		StringBuilder cipher = new StringBuilder();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int index = 0;
		for(int i = 0, len = plain.length();i<len;i++) {
			if(index == key.length()) index = 0;
			if(plain.charAt(i) == ' ') {
				cipher.append(' '); index++; continue;
			}
			int trans = plain.charAt(i) - key.charAt(index);
			if(trans > 0) {
				cipher.append(alphabet[trans-1]);
			} else {
				cipher.append(alphabet[trans + 25]);
			}
			index++;
		}
		System.out.println(cipher);
	}
}
