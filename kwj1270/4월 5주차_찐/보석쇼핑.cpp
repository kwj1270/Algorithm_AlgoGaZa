#include <string>
#include <vector>
#include <set>
#include <map>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = { 1, (int)gems.size() };
    map<string, int> m;
    set<string> s(gems.begin(), gems.end());
    int start = 0;
    int end = 0;
    int ans = gems.size();
    while(true){
        if(m.size() == s.size()){
            if(ans > end-start){
                ans = end-start;
                answer[0] = start+1;
                answer[1] = end;
            }
            if(m[gems[start]] == 1){
                m.erase(gems[start]);
                start++;
            }
            else if(m[gems[start]]-1 > 0){
                m[gems[start]]--;
                start++;
            }
        }else if(end == gems.size() || start == gems.size()){
            break;
        }else{
            m[gems[end]]++; // 개수 하나 증가시키고
            end++; // 다음 위치로 이동
        }
    }
    return answer;
}
