import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N * M + 1][N * M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int number = (i-1) * M + j;

                if (j != M) {
                    for (int k = 1; k <= M-j; k++) {
                        grid[number][number + k] = 1;
                    }
                }

                if (i != N) {
                    for (int k = i+1; k <= N; k++) {
                        int rowEqual = (k - 1) * M + j;
                        grid[number][rowEqual] = 1;
                    }
                }
            }
        }

        for (int number1 = 1; number1 <= N*M; number1++) {
            for (int number2 = number1; number2 <= N*M; number2++) {
                if(grid[number1][number2] == 1) continue;
                if(number1 == number2) continue;
                int number2I = (number2 / M) + 1;
                int number2J = number2 % M;

                grid[number1][number2] = grid[number1][(number2I - 2) * M + number2J] + grid[number1][(number2I-1) * M + number2J - 1];
            }
        }
        if (K == 0) {
            System.out.println(grid[1][N * M]);
            return;
        }

        System.out.println(grid[1][K] * grid[K][N*M]);
    }

}
