s = input()
result = []
for i in range(1,len(s)+1):
    result.append(s[-i:]) # 파이썬 꿀팁 (리스트 슬라이싱ㅎㅎ)
result.sort()
for c in result:
    print(c)