def toNum(char):   
    return ord(char.upper()) - 64  
N = int(input())
for _ in range(N):
    num  = int(input())
    arr = list(input().split(" "))
    answer = []
    for a in arr:
        if not answer:
            answer.append(a)
            continue
        if toNum(answer[0]) >= toNum(a):
            answer.insert(0,a)
        else:
            answer.append(a)    
    print("".join(answer))        