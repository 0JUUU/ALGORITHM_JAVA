import java.util.stream.*;
import java.util.*;
import java.io.*;

/**
 * BOJ 1120. 문자열
 * 2021.01.28
 * SSAFY 스터디
 * : return값의 중요성
 * @author 0JUUU
 *
 */
public class StringTest {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println(MinimumDiffBetweenAB(sc.next(), sc.next()));
		sc.close();
	}

	private static int MinimumDiffBetweenAB(String A, String B) {
		// @param A, B: Make algorithm using variable `A, B`
		// if u want to convert it to charArray : char[] someName = A.toCharArray();
		// if u want to convert it to StringArray : String[] someName = A.split("");
		// or using charAt() method: A.charAt(index);
		
		String[] a = A.split(""); String[] b = B.split("");
		int diff = 0; int min = 1000000000;
		// A, B : 길이가 같을 경우
		if(A.length() == B.length()) {
			for(int i = 0;i<a.length;i++) {
				if(!a[i].equals(b[i])) diff++;
			}
            return diff;
		}
		
		// A, B : 길이가 다를 경우
		// A 와 B의 차이만큼 돌려서 다른 문자값을 센다 
		else {
			int add = b.length - a.length;
			int[] different = new int[add];
			for(int i = 0;i<=add;i++) {
				diff = 0;
				for(int j = 0;j<a.length;j++) {
					if(!a[j].equals(b[j + i])) {
						diff++;
					}
				}
				if(min > diff) min = diff;
			}
            return min; // @return: diff between A and B
		}
	}
}
