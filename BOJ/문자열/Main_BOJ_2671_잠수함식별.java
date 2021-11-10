import java.util.*;
import java.io.*;

/**
 * BOJ 2671 잠수함식별
 * 2021.11.10
 * : 정규표현식 & String.matches 사용
 * + : 한 번 이상 등장
 * () : 그룹핑
 * @author 0JUUU
 *
 */
public class Main_BOJ_2671_잠수함식별 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = "(100+1+|01)+";
		if(str.matches(pattern))
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
	}
}
