import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

class Person implements Comparable<Person>{
    int id;
    int value; // 받은 수
    int wait;

    public Person(int id, int value, int wait) {
        this.id = id;
        this.value = value;
        this.wait = wait;
    }


    @Override
    public int compareTo(Person o) {
        int result = value-o.value;
        if(result == 0) return wait-o.wait;
        return result;
    }
}

public class Main {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int n; // 사진 틀
    private static int m;
    private static boolean[] isUsed = new boolean[101];

    private static PriorityQueue<Person> q;

    public static void main(String[] args) throws IOException {
        n = parseInt(BUFFERED_READER.readLine().trim());
        m = parseInt(BUFFERED_READER.readLine().trim());
        q = new PriorityQueue();

        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        for(int i=0; i < m; i++){
            int index = parseInt(stringTokenizer.nextToken());
            boolean flag = false;
            List<Person> personList = new ArrayList<>();
            while (!q.isEmpty()) {
                Person now = q.poll();
                if(now.id == index) {
                    now.value++;
                    flag = true;
                }
                personList.add(now);
            }
            for(int j=0; j < personList.size(); j++){
                q.offer(personList.get(j));
            }
            if(flag) continue;

            if(q.size() >= n) {
                q.poll();
            }
            q.offer(new Person(index, 1, i));

        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            answer.add(q.poll().id);
        }
        Collections.sort(answer);
        answer.forEach(i -> System.out.print(i+" "));

    }

    // 우선순위 큐,
    // 추천받은 순이 적은순서대로 앞으로, hashMap 사용 이름/추천수
    // 추천수 같아도 이하나 이상으로 취급해서 뒤로 보내면 됨

}
