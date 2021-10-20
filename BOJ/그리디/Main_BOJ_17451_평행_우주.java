import java.util.*;
import java.io.*;

/**
 * BOJ 17451 평행 우주
 * 2021.10.20
 * : long 은 진짜 주의하자!!!!!!
 * @author 0JUUU
 *
 */
public class Main_BOJ_17451_평행_우주 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] planets = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = n-1; i >=0; i--) {
			planets[i] = Long.parseLong(st.nextToken());
		}
		
		long speed = planets[0];
		for(int i = 1; i<n; i++) {
			if(speed > planets[i] && speed % planets[i] != 0) {
				long tmpSpeed = speed / planets[i];
				speed = (tmpSpeed+1) * planets[i];
			} else if(speed < planets[i]) {
				speed = planets[i];
			}
		}
		
		System.out.println(speed);
	}
}
