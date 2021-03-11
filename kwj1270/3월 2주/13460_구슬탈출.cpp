#include <iostream>
#include <vector>
#include <string>
using namespace std;
int dx[] = {0,0,1,-1}; // 4방향
int dy[] = {1,-1,0,0}; // 4방향
const int LIMIT = 10; // 10 제한

vector<int> gen(int k) { // 정수 k를 길이가 10인 4진법으로 나타내는 것
    vector<int> a(LIMIT);
    for (int i=0; i<LIMIT; i++) {
        a[i] = (k&3);
        k >>= 2;
    }
    return a;
}

pair<bool,bool> simulate(vector<string> &a, int k, int &x, int &y) {
    if (a[x][y] == '.') return make_pair(false, false); // 두 구슬중 하나가 빠지더라도 계속 이동시키자 했으니 빈칸이 있을 수 있다. -> 그때 리턴
    int n = a.size(); // 세로
    int m = a[0].size(); // 가로.
    bool moved = false; // 움직였다.
    while (true) {
        int nx = x+dx[k]; // 다음 이동
        int ny = y+dy[k]; // 다음 이동.
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위를 벗어나면
            return make_pair(moved, false); // 여태 저장된 움직임 가능/ 구멍에 안들어감 리턴
        }
        if (a[nx][ny] == '#') { // # 일 경우
            return make_pair(moved, false); // 여태 저장된 움직임 가능/ 구멍에 안들어감 리턴.
        } else if (a[nx][ny] == 'R' || a[nx][ny] == 'B') { // 서로 다른 구슬들일 경우도
            return make_pair(moved, false); // 여태 저장된 움직임 가능/ 구멍에 안들어감 리턴.
        } else if (a[nx][ny] == '.') { // 빈칸일 경우
            swap(a[nx][ny], a[x][y]); // 값 스왑. -> 구슬이랑 빈칸 바꾸기
            x = nx;
            y = ny;
            moved = true; // 한번이라도 움직였으니 true
        } else if (a[nx][ny] == 'O') { // 구멍일 경우
            a[x][y] = '.'; // 현재 위치 . 만들기 -> 구슬 하나 사라짐.
            moved = true; // 움직였다 체크
            return make_pair(moved, true); // 움직였다랑 / 구슬 빠졌다 리턴
        }
    }
    return make_pair(false, false); // 아무것도 실행 안되었다면 둘다 false
}
int check(vector<string> a, vector<int> &dir) {
    int n = a.size(); // 세로 크기
    int m = a[0].size(); // 가로 크기.
    int hx,hy,rx,ry,bx,by;
    for (int i=0; i<n; i++) { // 세로 반복
        for (int j=0; j<m; j++) { // 가로 반복
            if (a[i][j] == 'O') { // O 일 경우
                hx = i; hy = j; // 위치 저장
            } else if (a[i][j] == 'R') { // 빨강 구슬 R 일 경우
                rx = i; ry = j; // 위치 저장
            } else if (a[i][j] == 'B') { // 파랑 구슬 B 일 경우
                bx = i; by = j; // 위치 저장
            }
        }
    }
    int cnt = 0; // 카운트는 0 부터 시작.
    for (int k : dir) {
        cnt += 1; // 반복당 카운트 증가.
        bool hole1=false, hole2=false; // 둘다 안 들어 왔다.
        while (true) { // 무한 루프.
            auto p1 = simulate(a, k, rx, ry); // 빨강 구슬을 방향 k로 이동시키는 시뮬레이션 시작
            auto p2 = simulate(a, k, bx, by); // 파랑 구슬을 방향 k로 이동시키는 시뮬레이션 시작
            if (p1.first == false && p2.first == false) { // 둘다 이동 안함
                break; // b   r 일 경우 문제가 된다.  br 되어야 하므로 무한루프 및 둘 다 이동 못할 경우를 만들어 놓은 것.
            }
            if (p1.second) hole1 = true; // 구멍에 빠짐
            if (p2.second) hole2 = true; // 구멍에 빠짐
        }
        if (hole2) return -1; // 파랑 구슬이 빠졌다면 -1
        if (hole1) return cnt; // 파랑이 안빠졌고 빨강이 빠졌다는 뜻이므로 카운트 리턴
    }
    return -1;
}
bool valid(vector<int> &dir) {
    int l = dir.size();
    for (int i=0; i+1<l; i++) {
        if (dir[i] == 0 && dir[i+1] == 1) return false; // 반대
        if (dir[i] == 1 && dir[i+1] == 0) return false; // 반대
        if (dir[i] == 2 && dir[i+1] == 3) return false; // 반대
        if (dir[i] == 3 && dir[i+1] == 2) return false; // 반대.
        if (dir[i] == dir[i+1]) return false; // 같은 방향 의미가 없는 것.
    }
    return true;
}

int main() {
    // 초기화.
    int n, m;
    cin >> n >> m;
    vector<string> a(n);
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }

    // 정답 저장.
    int ans = -1;
    
    // 이동방법 k를 비트마스크로 만들기 위해서 LIMIT *2
    for (int k=0; k<(1<<(LIMIT*2)); k++) {
        vector<int> dir = gen(k); // dir 를 이용해서 방법으로 바꿔준다. -> 크기가 10인 4진법 수를 만드는 것.
        if (!valid(dir)) continue; // 의미가 없는 방법은 빼고 시뮬레이션 해보자.
        int cur = check(a, dir); // 보드 a 를 dir 방향으로 이동하는 것
        if (cur == -1) continue; // 가능하지 않다면 넘기기
        if (ans == -1 || ans > cur) ans = cur; // 가능하면 이동하기.
    }
    cout << ans << '\n'; // 결과.
    return 0;
}
