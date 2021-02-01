import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			ArrayList<Integer> memory = new ArrayList<>();
			int[] reset = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				memory.add(s.charAt(i) - '0');
				reset[i] = 0;
			}
			
			int count = 0;
			for (int i = 0; i < memory.size(); i++) {
				if (memory.get(i) != reset[i]) {
					count++;
					int change;
					if(reset[i] == 0) change = 1;
					else change = 0;
					for (int j = i; j < memory.size(); j++) { // 현재 가지고 있는 값 뒤집기
						reset[j] = change;
					}
				}
			}
			bw.write("#" + tc + " " + count + "\n");
		}
		bw.flush();
		bw.close();
	}
}
