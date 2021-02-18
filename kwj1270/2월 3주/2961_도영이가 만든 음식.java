import java.util.*;

class Mot {
    int sin;
    int sseun;

    public Mot(int sin, int sseun) {
        this.sin = sin;
        this.sseun = sseun;
    }
}

class Main {
    static Mot[] input;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        N = scanner.nextInt();
        input = new Mot[N];
        for (int i = 0; i < N; i++) {
            int temp_sin = scanner.nextInt();
            int temp_sseun = scanner.nextInt();
            input[i] = new Mot(temp_sin, temp_sseun);
        }
        generateSubSet(1 << N);
        System.out.println(answer);
    }

    private static void generateSubSet(int caseCount) {

        for (int flag = 1; flag < caseCount; flag++) {   // i는 비트마스킹이 되어있는 수
            int sin = 1;
            int sseun = 0;
            for (int j = 0; j < N; j++) { // 맨뒤부터 N개의 비트열을 확인한다. -> (1 << j) 이므로
                if ((flag & 1 << j) != 0) {
                    sin *= input[j].sin;
                    sseun += input[j].sseun;
                }
            }
            int abs = Math.abs(sin - sseun);
            answer = Math.min(answer, abs);
        }
    }
}
