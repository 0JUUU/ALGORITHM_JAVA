import java.util.*;
import java.io.*;
/**
 * BOJ 1655 가운데를 말해요
 * 2021.05.13
 * :TLE 
 * @author 0JUUU
 *
 */
public class Main_BOJ_1655_가운데를_말해요 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> numbers = new ArrayList<>();
		int num;
		for(int i = 1; i<=N;i++) {
			num = Integer.parseInt(br.readLine());
			numbers.add(num);
			Collections.sort(numbers);
			if(i % 2 == 1) {
				sb.append(numbers.get(i/2) +"\n");
			} else {
				sb.append(numbers.get((i/2)-1)+"\n");
			}
		}
		System.out.print(sb);
	}
}
