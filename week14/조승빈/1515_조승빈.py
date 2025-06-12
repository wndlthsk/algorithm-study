target = list(input().strip())
idx = 0
ans = 1
while True:
    for ch in str(ans):
        if idx < len(target) and target[idx] == ch:
            idx += 1
        if idx == len(target):
            print(ans)
            exit()
    ans += 1
