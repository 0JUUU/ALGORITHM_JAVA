import java.util.*;
import java.io.*;

/**
 * BOJ 16968 차량 번호판 1
 * 2021.04.01
 * @author 0JUUU	
 *
 */
public class Main_BOJ_16968_차량_번호판_1 {
	static String input;
	static int len, count = 1, ch, num, serialCh, serialNum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		len = input.length();
		for(int i = 0; i<len;i++) {
			if(input.charAt(i) == 'c') {
				serialNum = 0;
				serialCh++; 
				if(serialCh == 1) 
					count *= 26;
				else {
					count *= 25;
				}
			} else {
				serialCh = 0;
				serialNum++;
				if(serialNum == 1) 
					count *= 10;
				else {
					count *= 9;
				}
			}
		}
		System.out.println(count);
	}
}