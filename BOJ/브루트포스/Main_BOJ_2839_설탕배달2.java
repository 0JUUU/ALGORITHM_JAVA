import java.util.*;
import java.io.*;

public class Main_BOJ_2839_설탕배달2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sugar = -1;
		if (N != 4 && N != 7) {
			switch (N % 5) {
			case 0:	sugar = N / 5; break;
			case 1:	sugar = (N / 5) + 1; break;	// N/5 - 1 + 1 * 2 
			case 2:	sugar = (N / 5) + 2; break;	// N/5 - 2 + 1 * 4
			case 3:	sugar = (N / 5) + 1; break;	
			case 4:	sugar = (N / 5) + 2; break;	// N/5 - 1 + 1 * 3
			}
		}
		System.out.println(sugar);
	}
}
