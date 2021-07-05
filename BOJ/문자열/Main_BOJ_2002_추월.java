import java.util.*;
import java.io.*;

/**
 * BOJ 2002 추월
 * 2021.07.05
 * : 해시맵 & boolean 배열 사용 ==> 내 숫자보다 앞인 애들이 아직 안나갔다면 추월했다는 의미!
 * @author 0JUUU
 *
 */
public class Main_BOJ_2002_추월 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> carList = new HashMap<>();
		for(int i = 0; i<N;i++) {
			String carName = br.readLine();
			carList.put(carName, i);
		}
		
		int cnt = 0;
		boolean[] isOut = new boolean[N];
		for(int i = 0; i<N;i++) {
			String carName = br.readLine();
			int num = carList.get(carName);
			for(int j = 0; j<num;j++) {
				if(!isOut[j]) {
					cnt++;
					break;
				}
			}
			isOut[num] = true;
		}
		System.out.println(cnt);
	}
}
