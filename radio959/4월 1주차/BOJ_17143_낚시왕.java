package week10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	static class shark {
		int r, c;
		int speed, direction, size;
		
		public shark() {
			this.r = 0;
			this.c = 0;
			this.speed = 0;
			this.direction = 0;
			this.size = 0;
		}

		public shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.speed = s;
			this.direction = d;
			this.size = z;
		}
	}
	
	static int R,C,M;
	static shark[][][] board;
	static boolean[][] live;
	static int[] dx = {99999, -1, 1, 0, 0}; // 0은 모르고 1234가 상하좌우
	static int[] dy = {99999, 0, 0, -1, 1}; 
	static int[] newdirection = {99999, 2,1,4,3}; // 1번(상)을 넣으면 2번(하)가 입력 되게끔 
	static ArrayList<shark> list;
	static int ans=0;
	static int r1,c1,s1,d1,z1;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new shark [R+1][C+1][2];
		live = new boolean [R+1][C+1];
		list = new ArrayList<shark>();
		
		for(int i=1; i<=R; i++) { 
			for(int j=1; j<=C; j++) { 
				board[i][j][0] = new shark();
				board[i][j][1] = new shark();
			}
		}
		
		// 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			s1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			z1 = Integer.parseInt(st.nextToken());
			board[r1][c1][0] = new shark(r1,c1,s1,d1,z1);
			list.add(board[r1][c1][0]);
			live [r1][c1] = true;
		}
		
		
		
		// i를 1~C까지 FOR 하면서 move
		for(int i=1; i<=C; i++) { // 1. 낚시왕이 오른쪽으로 한칸 이동한다.
			move(i); // 2. 낚시왕이 있는 열에 있는 상어중에서 제일 가까운 것을 잡는다.
			sharkmove(); // 3. 상어가 이동한다.
		}
		
		System.out.println(ans);
		
	}
	public static void move(int i) {
		// column i 에 대해
		for(int j=1; j<=R; j++) {
			// 상어가 있다면
			if (live[i][j]) {
				// 정답에다가 상어 크기를 넣고 다음으로 넘어가도록 한다.
				ans += board[i][j][0].size;
				// 더이상 해당 칸에는 상어가 살지 않으므로 false 처리 해준다.
				live[i][j] = false;
				board[i][j][0] = new shark(0,0,0,0,0);  
				break;
			}
		}
	}
	
	public static void sharkmove() {
		shark init;
		init = new shark();
		// 상어가 이동해야 함.
		// 리스트에 들어가있는 상어들에 대해서 이동 진행
		for(shark s : list) {
			int startr = s.r;
			int startc = s.c;
			
			for(int i=0; i<s.speed; i++) {
				if(s.direction==1) {
					s.r -= 1;
					if(s.r<1) {
						s.direction = newdirection[1];
						s.r = 2;
					}
				}else if (s.direction==2) {
					s.r += 1;
					if(s.r>R) {
						s.direction = newdirection[2];
						s.r = R-1;
					}
				}else if (s.direction==3) {
					s.c -= 1;
					if(s.c<1) {
						s.direction = newdirection[3];
						s.r = 2;
					}
				}else if (s.direction==4) {
					s.c += 1;
					if(s.c>C) {
						s.direction = newdirection[4];
						s.c = C-1;
						
					}
				}
			}
			// 우선은 1층에다가 상어 데이터를 넣어두고, 1층에서 만나면 잡아 먹는 방식
			// size가 0이면 없는거.
			if(board[s.r][s.c][1].size==0) {
				// 1층에 이동한 상어 넣고
				board[s.r][s.c][1] = s;
				// 원래 0층에 있던 상어 초기화
				board[startr][startc][0] = init;
			}
			
			// 근데 만약 1층에 상어가 있다면?
			if(board[s.r][s.c][1].size!=0) { // 사이즈 비교
				if(board[s.r][s.c][1].size<s.size) { // 기존것보다 크면
					board[s.r][s.c][1]=s; // 상어데이터 갱신
				} // 기존 것보다 작으면 갱신할 필요 없이 원래 상어만 초기화
				// 원래 0층에 있던 상어 초기화
				board[startr][startc][0] = init;
			}
			
		}
		
		// 1층에 있던 상어를 다 0층으로 내림으로써 다음 단계에서의 계산 실수 방지.
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(board[i][j][1].size!=0) {
					board[i][j][0] = board[i][j][1];
					board[i][j][1] = init;
				}
			}
		}
	}
	
}
