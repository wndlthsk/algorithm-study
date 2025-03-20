import sys

n, c = map(int, sys.stdin.readline().split())
home = []
for _ in range(n):
    home.append(int(sys.stdin.readline()))
home.sort()

start, end = 1, home[-1]-home[0]
result = 0

while start <= end:
    # print("s:", start, "e: ", end)
    mid = (start + end) // 2
    current = home[0]
    count = 1

    for i in range(1, n):
        # print("home: ", home[i], "current:", current, "count:", count)
        if home[i] - current >= mid: # 설치한 집과 다른 집의 거리가 사이 거리의 중간 값보다 크면
            current = home[i]
            count += 1

    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)