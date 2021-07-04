import java.util.*;
import java.io.*;
/**
 * BOJ 9935 문자열 폭발
 * 2021.07.04
 * : mle
 * @author user
 *
 */

public class Main_BOJ_9935_문자열_폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String exp = br.readLine();
		
		int expLen = exp.length();
        int strLen = str.length();
        char[] tChar = new char[expLen];
        
        for(int i = 0; i<expLen;i++) {
            tChar[i] = exp.charAt(i);
        }
        int sIndex = 0;
        int tIndex = 0;
        while(sIndex < str.length() ) {
            if(str.charAt(sIndex) == exp.charAt(tIndex)) {
                sIndex++; tIndex++;
            } else if(tIndex == 0) {
            	sIndex++;
            } else {
                tIndex = 0;
            }
            if(tIndex == expLen) {
                str = str.substring(0, sIndex-expLen).concat(str.substring(sIndex));
                sIndex = sIndex > 2 * expLen ? sIndex - 2*expLen : 0;
                tIndex = 0;
            }
        }
        if(str.equals("")) System.out.println("FRULA");
        else System.out.println(str);
	}
}
