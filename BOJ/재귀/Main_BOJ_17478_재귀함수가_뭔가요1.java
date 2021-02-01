import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17478. 재귀함수가 뭔가요?
 * 2021.02.01
 * SSAFY WORKSHOP
 * : 나는 무작정 풀려고만해서 그냥 출력문을 모두 써버림
 * : 나오는 문자열을 정리해서 배열에 넣고 필요한 것을 그때그때 가지고 와서 출력하는 것이 훨씬 깔끔함
 * @author OJUUU
 *
 */
public class Main_BOJ_17478_재귀함수가_뭔가요1 {
	static String[] response = new String[6];
	
	private static void recursive(int N, String line) {
		if(N == 0) {
			System.out.println(line+response[0]);
			System.out.println(line+response[4]);
			System.out.println(line+response[5]);
			return;
		}
		
		System.out.println(line+response[0]);
		System.out.println(line+response[1]);
		System.out.println(line+response[2]);
		System.out.println(line+response[3]);
		
		recursive(N-1, line+"____");
		System.out.println(line+response[5]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");	// 이야기 시작 : 재귀 내용과 관련 X --> 초기에 출력
		
		response[0] = "\"재귀함수가 뭔가요?\"";
		response[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		response[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		response[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		response[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		response[5] =  "라고 답변하였지.";
		
		recursive(N,"");
	}
}
