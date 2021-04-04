import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static StringBuilder STANDARD;
    private static StringBuilder TARGET;

    public static void main(String[] args) throws IOException {
        STANDARD = new StringBuilder(BUFFERED_READER.readLine().trim());
        TARGET = new StringBuilder(BUFFERED_READER.readLine().trim());

        boolean flag = false;
        while (true) {
            if(STANDARD.length() == TARGET.length()) {
                if(STANDARD.toString().equals(TARGET.toString())){
                    flag = true;
                }
                break;
            }

            if(TARGET.length() > 0) {
                char alpha = TARGET.charAt(TARGET.length()-1);
                TARGET.setLength(TARGET.length()-1);
                if(alpha == 'B') {
                    TARGET.reverse();
                }
            }

        }
        System.out.println(flag ? 1 : 0);

    }

}
