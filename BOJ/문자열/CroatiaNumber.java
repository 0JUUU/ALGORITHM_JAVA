import java.util.stream.*;
import java.util.*;
import java.io.*;

/**
 * BOJ 2941. 크로아티아 알파벳
 * 2021.01.28
 * SSAFY 스터디
 * 1. 처음 푼 것 : 크로아티아 문자를 제외한 나머지것들의 조합으로 또 크로아티아 문자를 만들 가능성이 있음
 * 2. 그 다음 고친 것 : 크로아티아 문자열에 저장한 순서대로 나오지 않으면 값이 잘못 나올 경우가 있음
 * 3. replace, replaceAll 알게 된 후 : String의 replace와 replaceAll을 제대로 알면 쉽게 풀리는 문제!
 * */
public class CroatiaNumber {
	public static void main(String[] args) throws Exception {
		printResult(getLengthOfKroatiaWord(makeInput()));
	}

	private static int getLengthOfKroatiaWord(String word) {
		// @param word: Make algorithm using variable `word`
		String[] croatia = {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
		
		for(int i = 0;i<8;i++) {
			word = word.replace(croatia[i], "$");	
		}
		

		return word.length(); // @return: the length Of Kroatia Word
	}

	private static String makeInput() { return new Scanner(System.in).next();}
	private static void printResult(int lengthOfKroatiaWord) { System.out.println(lengthOfKroatiaWord); }
}

//public class CroatiaNumber {
//	public static void main(String[] args) throws Exception {
//		printResult(getLengthOfKroatiaWord(makeInput()));
//	}
//
//	private static int getLengthOfKroatiaWord(String word) {
//		// @param word: Make algorithm using variable `word`
//		String[] croatia = {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
//		int alpabet = 0;
//		int remain = 0;
//		for(int i = 0;i<8;i++) {
//			String word1;
//			while(word.contains(croatia[i])) {
//				int index = word.indexOf(croatia[i]);
//				word1 = word.substring(0,index);
//				
//				String word2 = word.substring(index+croatia[i].length());
//				word = word2;
//				alpabet++;
//				remain += word1.length();
//			}
//			
//		}
//
//		return word.length() + alpabet + remain; // @return: the length Of Kroatia Word
//	}
//
//	private static String makeInput() { return new Scanner(System.in).next();}
//	private static void printResult(int lengthOfKroatiaWord) { System.out.println(lengthOfKroatiaWord); }
//}
