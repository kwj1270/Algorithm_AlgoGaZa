

def solution(new_id):
    answer = ''
    #1. 모두 소문자로 치환
    new_id = new_id.lower()
    #2. 소문자 숫자 - _ . 제외 모든 문자 제거
    
    for c in new_id[:]:
        if c.islower(): answer += c
        if c.isdigit(): answer += c
        if c in ['-', '_', '.'] : answer += c
    #print("2단계",temp)

    #3. ..이 2번이상연속되면 . 하나로 치환
    cnt = 0
    tmp = []
    for i, c in enumerate(answer) :
        if c == '.': 
            if cnt == 0:    
                tmp += c
            cnt+=1
        else:
            cnt = 0
            tmp += c # . 아니면 바로 누적
    #print("3단계",tmp)

    #4 . 처음이나 끝이면 제거
    if(tmp[0] == '.'): tmp.pop(0)
    if(len(tmp) > 0 and tmp[-1] == '.'): 
        if len(tmp) > 0:
            tmp.pop(-1)
    #print("4단계",tmp)

    #5. 빈 문자열이면 a를 대입
    if len(tmp) == 0 : tmp += 'a'
    #print("5단계",tmp)

    #6. 길이 16이상이면, 첫 15개 제외 나머지 제거
    if len(tmp) >= 16 : 
        tmp = tmp[:15]
        if tmp[-1] == '.' : tmp = tmp[:-1]
    #print("6단계",tmp)

    #7. 길이 2자 이하, 
    if len(tmp) <= 2:
        c = tmp[-1]
        while(True):
            if(len(tmp) == 3) : break
            tmp += c
    
    answer = "".join(tmp)
    # print("7단계",answer)
    return answer

if __name__ == "__main__":
    #마침표는 처음과 끝 사용 불가. 연속 사용 불가
    
    new_id = "abcdefghijklmn.p"
    solution(new_id)