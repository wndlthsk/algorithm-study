import sys
n = int(sys.stdin.readline())
info = dict()
for i in range(n*n):
    tmp = list(map(int, sys.stdin.readline().split()))
    info[tmp[0]] = tmp[1:]
numbers = list(info.keys())
# print(numbers)
seat = [[0] * n for _ in range(n)]
# seat[(n-1) // 2][(n-1) // 2] = numbers[0]

for num in numbers:
    candidates = []
    for i in range(n):
        for j in range(n):
            if seat[i][j] == 0:
                likes_count = 0
                empty_count = 0
                for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]: # 상하좌우
                    nx, ny = i + dx, j + dy
                    if 0 <= nx < n and 0 <= ny < n:
                        if seat[nx][ny] in info[num]:
                            likes_count += 1
                        if seat[nx][ny] == 0:
                            empty_count += 1
                candidates.append((likes_count, empty_count, i, j))
    # print(num)
    candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3])) # 내림/내림/오름/오름 차순
    seat[candidates[0][2]][candidates[0][3]] = num
# print(seat)

score = 0
for i in range(n):
    for j in range(n):
        count = 0
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = i + dx, j + dy
            if 0 <= nx < n and 0 <= ny < n:
                if seat[nx][ny] in info[seat[i][j]]:
                    count += 1
        if count == 1:
            score += 1
        elif count == 2:
            score += 10
        elif count == 3:
            score += 100
        elif count == 4:
            score += 1000

print(score)