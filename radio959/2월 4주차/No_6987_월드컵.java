package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	월드컵 조별 최종 예선에서는 6개국으로 구성된 각 조별로 동일한 조에 소속된 국가들과 한 번씩, 각 국가별로 총 5번의 경기를 치른다. 
	조별리그가 끝난 후, 기자가 보내온 각 나라의 승, 무승부, 패의 수가 가능한 결과인지를 판별하려고 한다. 
	네 가지의 결과가 주어질 때 각각의 결과에 대하여 가능하면 1, 불가능하면 0을 출력하는 프로그램을 작성하시오.
*/
public class No_6987_월드컵 {

	static int win, draw, lose;
	static int wsum,cnt,lsum;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 모든 나라의 승수의 합 == 패수의 합 으로 판별 가능
		// 무승부 판별 알고리즘?
		// 내가 생각한 알고리즘
		// 승수 합 == 패수 합이면 
		
		for (int tc = 0; tc < 4; tc++) {
			wsum=cnt=lsum=0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				win = Integer.parseInt(st.nextToken());
				draw = Integer.parseInt(st.nextToken());
				lose = Integer.parseInt(st.nextToken());
				
				if(win==6 || draw==6||lose==6) {
					sb.append(0);
					break;
				}
				
				wsum+=win;
				lsum+=lose;
				
				
			}
			sb.append(" ");
		}
	}
}
