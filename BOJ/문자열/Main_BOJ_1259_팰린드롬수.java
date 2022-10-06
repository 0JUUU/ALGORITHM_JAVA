import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1259_팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String number = br.readLine();
            if (number.equals("0")) {
                break;
            }
            String reverseNumber = new StringBuffer(number).reverse().toString();
            if (number.equals(reverseNumber)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}
