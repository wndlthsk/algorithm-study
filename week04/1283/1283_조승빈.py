n = int(input())
memo = set()
for _ in range(n):
    word = input().split(" ")
    flag = 0
    for i in range(len(word)):
        if word[i][0].lower() not in memo:
            memo.add(word[i][0].lower())
            word[i] = "["+ word[i][0]+"]"+word[i][1:]
            flag = 1
            break
    if flag == 0:
        for i in range(len(word)):
            if flag ==1 :
                break
            for col in range(1,len(word[i])):
                if word[i][col].lower() not in memo:
                    memo.add(word[i][col].lower())
                    word[i] = word[i][0:col]+"["+ word[i][col]+"]"+word[i][col+1:]
                    flag = 1
                    break
            
    for a in word:
        print(a,end=" ")
    print()
