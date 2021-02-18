import java.util.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int[] d;

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        N = scanner.nextInt();
        d =  new int [5001];
        Arrays.fill(d, Integer.MAX_VALUE);

        d[3] = 1;
        d[5] = 1;
        for(int i=6; i <= N; i++) {
            if(i%3 == 0 || d[i-3] != Integer.MAX_VALUE) d[i] = d[i-3]+1;
            if(i%5 == 0 || d[i-5] != Integer.MAX_VALUE) d[i] = d[i-5]+1;
        }
        System.out.println(d[N] == Integer.MAX_VALUE ? -1 : d[N]);



    }

}
