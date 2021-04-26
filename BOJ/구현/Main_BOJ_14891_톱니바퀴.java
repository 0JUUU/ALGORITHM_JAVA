import java.util.*;
import java.io.*;

public class Main_BOJ_14891_톱니바퀴 {
	static int K;
	static Magnetic[] mag;
	static boolean[] isNS; // 인접해있는 자석이 다른 극인지 저장하는 배열

	// 자석 클래스
	static class Magnetic {
		int number;
		LinkedList<Integer> wings = new LinkedList<>();
		boolean isRotate;

		public Magnetic(int number, LinkedList<Integer> wings) {
			super();
			this.number = number;
			this.wings = wings;
			this.isRotate = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		mag = new Magnetic[4];

		// 각 자석의 날의 자성 입력
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			LinkedList<Integer> wings = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				wings.add(s.charAt(j) - '0');
			}
			mag[i] = new Magnetic(i + 1, wings);
		}

		K = Integer.parseInt(br.readLine());
		// K번 회전
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			// 자석의 회전 여부 초기화
			for (int m = 0; m < 4; m++) {
				mag[m].isRotate = false;
			}

			// 1(2)-(6)2 / 2(2)-(6)3 / 3(2)-(6)4 : 인접해있는 자석이 다른 극인지
			isNS = new boolean[3];
			for (int j = 0; j < 3; j++) {
				if (mag[j].wings.get(2) != mag[j + 1].wings.get(6)) {
					isNS[j] = true;
				}
			}

			// 여기 자석부터 돈다라고 표시
			mag[num - 1].isRotate = true;

			// 돌 수 있는 자석에서 퍼져 나간다 --> 왼쪽 오른쪽 체크
			int left = num - 2, right = num;
			for (int j = left; j >= 0; j--) {
				if (!mag[j + 1].isRotate)
					break;
				if (isNS[j] && mag[j + 1].isRotate)
					mag[j].isRotate = true;
			}

			for (int j = right; j < 4; j++) {
				if (!mag[j - 1].isRotate)
					break;
				if (isNS[j - 1] && mag[j - 1].isRotate)
					mag[j].isRotate = true;
			}
			rotate(num - 1, dir);
		}

		int ans = 0;
		for (int i = 0; i < 4; i++)
			ans += Math.pow(2, i) * mag[i].wings.peekFirst();

		System.out.println(ans);
	}

	private static void rotate(int num, int dir) {

		// dir == 1 : 시계 / -1 : 반시계
		for (int i = 0; i < 4; i++) {
			if (!mag[i].isRotate)
				continue;
			int r = num % 2 == i % 2 ? dir : -1 * dir;
			if (r == 1) {
				mag[i].wings.addFirst(mag[i].wings.pollLast());
			} else {
				mag[i].wings.addLast(mag[i].wings.pollFirst());
			}
		}
	}
}
