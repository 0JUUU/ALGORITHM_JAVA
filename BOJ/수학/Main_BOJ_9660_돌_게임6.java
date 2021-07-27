import java.util.*;
import java.io.*;

/**
 * BOJ 9660 돌 게임 6
 * 2021.07.28
 * @author 0JUUU
 *
 */
public class Main_BOJ_9660_돌_게임6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		if(N % 7 == 2 || N % 7 == 0) System.out.println("CY");
		else System.out.println("SK");

	}
}
