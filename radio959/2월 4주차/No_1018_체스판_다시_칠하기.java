package week5;

/*
 *	지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 
	나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.

	체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 
	변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 
	하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

	보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
	당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1018_체스판_다시_칠하기 {
	static int M;
	static int N;
	static char[][] board;
	static boolean[][] check;
	static int cnt;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				// 8*8배열이 n개가 생성될텐데, 그 시작점만 search 메소드에 넘겨준다. search는 시작점을 기준으로 8*8배열을 탐색하는
				// 메소드다.
				cnt=0;
				boundx = i;
				boundy = j;
				temp = 'W';
				min = Math.min(min, search(i, j));
				temp = 'B';
				min = Math.min(min, search(i, j));
			}
		}
		System.out.println(min);
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int boundx, boundy;
	static char temp;

	public static int search(int r, int c) {
		if(r==boundx+7 && c == boundy+7)
			return 0;
		/*
		 * 내가 생각한 풀이법 
		 * 1. 우선 시작점부터 방문했으니까 방문처리를 해준다. 
		 * 2. 4방탐색 배열을 사용해서 4방탐색을 시작한다. 범위바깥 || 이미 방문한 곳은 continue 
		 * 3. 근데 시작칸이 W일 때, B일 때 나눠서 생각해야함.
		 */
		check[r][c] = true;
		
		if(temp==board[r][c]) {
			cnt++;
		}
		
		if(temp=='W') temp = 'B';
		else temp = 'W';
		
		for (int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if (nx >= boundx && nx < boundx + 8 && ny >= boundy && ny < boundy + 8 && !check[nx][ny]) {
				search(nx,ny);
			}
		}
		check[r][c] = false;
		return cnt;
	}

}
