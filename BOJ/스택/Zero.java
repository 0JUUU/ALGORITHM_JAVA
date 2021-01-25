import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10773. 제로
 * @author clleo
 *
 */
public class Zero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] num = new int[100000];
		int index = 0;
		for(int k = 0;k <K; k++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) index--;
			else {
				num[index] = N;
				index++;
			}
		}
		
		int sum = 0;
		for(int i = 0;i<index;i++) {
			sum += num[i];
		}
		
		System.out.println(sum);
	}
}
