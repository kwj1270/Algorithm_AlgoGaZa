from collections import defaultdict

def solution(gems):
    answer = [] # 길이, [시작인덱스, 끝인덱스]
    countGems = defaultdict(int)
    countGems[gems[0]]=1
    typeCnt = len(set(gems)) # 보석 종류 개수
    length = len(gems) # 진열대 길이

    start,end = 0,0
    while start < length and end < length:
        if len(countGems) < typeCnt: # 아직 보석 다 못삼
            end+=1 #오른쪽으로 이동
            if end == length: 
                break
            countGems[gems[end]]+=1 # 이동했으니깐 보석 빈도수 증가

        # 조건 만족함
        if len(countGems) == typeCnt:
            answer.append((end-start, [start+1, end+1]))

            #왼쪽빼주기
            countGems[gems[start]]-=1
            if countGems[gems[start]] == 0:
                del countGems[gems[start]]
            start += 1

    answer = sorted(answer, key=lambda x : (x[0], x[1])) # 길이가 같으면 인덱스가 작게
    return answer[0][1]

if __name__ == "__main__":
    gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
    print(solution(gems))