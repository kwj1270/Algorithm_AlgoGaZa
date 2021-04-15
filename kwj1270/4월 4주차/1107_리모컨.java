import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

import static java.lang.Integer.valueOf;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static final int DEFAULT_CHANNEL = 100;

    private static StringTokenizer stringTokenizer;

    private static int target;
    private static int breakCount;

    private static boolean[] broken;

    public static void main(String[] args) throws IOException {

        target = valueOf(BUFFERED_READER.readLine());
        breakCount = valueOf(BUFFERED_READER.readLine());
        broken = new boolean[10];

        if(0 != breakCount) {
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for (int i = 0; i < breakCount; i++) {
                broken[valueOf(stringTokenizer.nextToken())] = true;
            }
        }

        int answer = Math.abs(target - DEFAULT_CHANNEL);
        for (int i = 0; i <= 1_000_000; i++) {
            int length = size(i);
            if(length > 0) {
                int press = Math.abs(i-target); // 현재 반복 횟수 - 찾는값
                if(answer > length+press){
                    answer = length + press;
                }
            }
        }
        System.out.println(answer);

    }

    private static int size(int channel) {
        if(channel == 0) {
            if(broken[0]) return 0;
            return 1;
        }
        int count = 0;
        while (channel > 0){
            int suffix = channel%10;
            if(broken[suffix]) return 0;
            count++;
            channel/=10;
        }
        return count;
    }


}
