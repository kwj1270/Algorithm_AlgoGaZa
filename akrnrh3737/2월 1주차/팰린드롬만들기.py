from collections import deque

def makePallendrome(s):
    result=[]
    lis = sorted([x for x in s])
    charCounter = {}
    
    for c in lis:
        charCounter[c] = charCounter.get(c,0)+1

    if(len(lis)%2==1):
        # 중간 값 찾기
        center = ''
        for k,v in charCounter.items():
            if v == 1:
                center = k
        
        l = 0 # left idx 
        q = deque()
        while(len(q) < len(lis)//2):
            q.append(lis[l])
            l+=2
        result = [x for x in q]
        result += center
        result += result[len(result)-1::-1]

    else:
        lis = sorted([x for x in s],reverse=True)
        l = 0
        q = deque()
        while(len(q) <= len(lis) and l < len(lis)):
            q.append(lis[l])
            q.appendleft(lis[l])
            l+=2
        result = [x for x in q]

    return "".join(result)

if __name__ == "__main__":
    name = input()
    dic = {}
    answer = []
    if(len(name)%2==0):
        for c in name:
            dic[c] = dic.get(c,0)+1
        #글자 count 값이 모두 짝수개여야함
        for key in dic.keys():
            if(dic[key]%2==1):
                print("I'm Sorry Hansoo")
                break
        print(makePallendrome(name))

                
    else:
        for c in name:
            dic[c] = dic.get(c,0)+1
        if(1 in dic.values()):
            cnt=0
            for key in dic.keys():
                if(dic[key]%2==0):
                    cnt+=dic[key]
            if cnt+1 == len(name):
                print(makePallendrome(name))



