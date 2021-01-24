import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	SW Expert 5432. 쇠막대기 자르기
 * 
 * 	2021.01.24
 * */

public class CutStick {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1;tc<=T;tc++) {
			String s = bf.readLine();
			int count = 0, stick = 0, close = 0;
			for(int l = 0;l<s.length();l++) {
				if(s.charAt(l) == '(') stick++;
				else {		// charAt(l) == ')'
					
					if(s.charAt(l-1) == '(') {
						stick--;
						count+= stick;
					}
					else {
						close += 1;
						if(l == s.length() - 1) {
							count+= close; break;
						}
						if(s.charAt(l+1) == '(') {
							count += close; stick -= close; close = 0;
						}
					} 
				}
			}
			System.out.println("#"+ tc+" " + count);
		}
	}
}
