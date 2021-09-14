import java.io.*;

/**
 * BOJ 12871 무한 문자열
 * 2021.09.14
 * bababa
 * babababa
 * => 1
 * @author 0JUUU
 *
 */
public class Main_BOJ_12871_무한_문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String t = br.readLine();
		StringBuilder ssb = new StringBuilder();
		StringBuilder tsb = new StringBuilder();
		
		for(int i = 0, tLen = t.length(); i<tLen;i++) {
			ssb.append(s);
		}
		
		for(int i = 0, sLen = s.length(); i<sLen;i++) {
			tsb.append(t);
		}

		if(ssb.toString().equals(tsb.toString())) System.out.println(1);
		else System.out.println(0);
	}
}
