import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21318 피아노 체조
 *
 * 2022.10.04
 * 이전에 풀었던 방식과 달라졌다
 * 한번 비교해보자
 */
public class Main_BOJ_21318_피아노_체조 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] notes = new int[N+1];
        int[][] mistakes = new int[2][N+1];     // 굳이 [N+1][N+1]을 가질 필요가 없다! -> 1차원으로도 될 수도...? 
        StringTokenizer st = new StringTokenizer(br.readLine());
        mistakes[1][1] = 0;
        for (int i = 1; i <= N; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
            if(i == 1) continue;
            if (notes[i] < notes[i - 1]) {
                mistakes[1][i] = mistakes[1][i-1] + 1;
            } else {
                mistakes[1][i] = mistakes[1][i - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(mistakes[1][y] - mistakes[1][x]).append("\n");
        }
        System.out.print(sb);
    }
}
