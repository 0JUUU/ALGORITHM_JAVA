import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1755_숫자놀이 {	
	// 숫자와 숫자를 문자로 바꾼 값을 저장할 Number 클래스 (Comparable<Number>로 문자로 바꾼 값을 오름차순 정렬할 수 있도록 한다.)
	static class Number implements Comparable<Number> {
		int num;	// 숫자값
		String alphabet;	// 숫자를 문작로 바꾼 값
		public Number(int num, String alphabet) {	// 생성자
			super();								// 부모 생성자 호출
			this.num = num;							// 입력받은 num을 해당 클래스에 저장
			this.alphabet = alphabet;				// 입력받은 alphabet을 해당 클래스에 저장
		}
		@Override	
		public int compareTo(Number o) {			// 문자를 오름차순 정렬하기 위한 오버라이딩 함수
			return this.alphabet.compareTo(o.alphabet);		// 해당 클래스와 비교하는 클래스의 alphabet을 오름차순으로 정렬
		}
		
	}
	public static void main(String[] args) throws Exception {		// main 함수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력받기 위해 해당 라인 작성
		StringBuilder sb = new StringBuilder();			// 출력 속도를 높이기 위해 사용
		StringTokenizer st = new StringTokenizer(br.readLine());	// M과 N을 입력받기 위해 사용
		
		int M = Integer.parseInt(st.nextToken());	// M 이상
		int N = Integer.parseInt(st.nextToken());	// N 이하
		String[] numToAlpha = {"zero", "one", "two","three","four","five","six","seven","eight","nine"};	// 어떠한 숫자에 대응하는 문자를 쉽게 찾기 위해 저장한 배열
		
		Number[] numbers = new Number[N-M + 1];		// M 이상 N 이하의 숫자들에 관한 정보를 저장하기 위해 Number 클래스를 N-M+1개만큼 선언
		
		for(int i = M; i<=N;i++) {					// M 이상 N 이하까지 수들을 처리하기 위한 for문
			String alpha = null;					// 해당 숫자를 문자열로 변환할 경우를 저장할 변수 alpha
			if(i / 10 == 0) alpha = numToAlpha[i];	// M과 N은 1 이상 99이하의 숫자이므로 최대 자릿수가 2이다. 그러므로 자리수가 1일 때와 2일 때로 나눌 수 있다. 이 경우는 자리수가 1일때이다. 
			else {									// 자리수가 2일 때
				int tmp = i / 10;					// 첫번째 자리의 숫자를 구하기 위해 10으로 나눈 몫을 tmp로 저장한다.
				alpha = numToAlpha[tmp];			// 몫에 해당하는 문자를 alpha에 저장한다.
				alpha += numToAlpha[i % 10];		// 나머지 수에 해당하는 문자를 alpha에 덧붙여준다.
			}	// end else
			numbers[i-M] = new Number(i, alpha);	// 숫자와 처리한 문자열을 Number 클래스에 저장한다.
		}	// end for
		
		Arrays.sort(numbers);						// numbers를 정렬한다. (문자열 오름차순)
		for(int i = 0; i<numbers.length;i++) {		// 정렬한 numbers를 출력하기 위한 for문
			sb.append(numbers[i].num + " ");		// StringBuilder에 각 Number 클래스의 숫자를 공백을 포함하여 덧붙인다. 
			if(i % 10 == 9) sb.append("\n");		// 한 줄에 10개씩 출력해야하므로 0~9까지 진행했으면 한줄 띄어쓰기를 덧붙인다.
		}	// end for
		
		System.out.print(sb);		// StringBuilder를 출력한다.
	}		// end main
}
