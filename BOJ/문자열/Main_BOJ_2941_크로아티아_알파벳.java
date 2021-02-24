import java.io.*;
import java.util.*;

/**
 * BOJ 2941 크로아티아 알파벳
 * 2021.02.24
 * : 이전에 풀어봤던 문제! String의 method를 잘 활용하자
 * @author 0JUUU
 *
 */
public class Main_BOJ_2941_크로아티아_알파벳 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String s = br.readLine();
		for(int i = 0; i<8; i++) {
			if(s.contains(croatia[i])) s= s.replace(croatia[i],"^");	// --> s = s.replace(croatia[i], "^"); 이렇게도 가능 (contains로 확인필요x)
		}
		System.out.println(s.length());
		
	}
}
