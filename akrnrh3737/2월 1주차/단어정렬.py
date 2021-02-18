size = int(input())
lis = []
for _ in range(size):
    s = input()
    if s not in lis:
        lis.append(s)

##길이가짧은것부터 길이가같으면 사전순 정렬
lis.sort(key=lambda x : (len(x), x))
for word in lis:
    print(word)

    
