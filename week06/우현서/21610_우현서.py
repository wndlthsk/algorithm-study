import sys

n, m = map(int, sys.stdin.readline().split())
a = []
for i in range(n):
    a.append(list(map(int, sys.stdin.readline().split())))
d = []
s = []
for i in range(m):
    x, y = map(int, sys.stdin.readline().split())
    d.append(x)
    s.append(y)
# print(a)
# print(d)
# print(s)

direction = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
diagonal = [(-1,-1), (1, -1), (-1, 1), (1, 1)]

# 초기 구름
cloud = [[n-1, 0], [n-1, 1], [n-2, 0], [n-2, 1]]
new_cloud = []
# print(cloud)

for i in range(m):
    # print(i, "번째")
    td = d[i] - 1
    ts = s[i]
    # 1. 구름 이동
    for c in cloud:
        c[0] = (c[0] + direction[td][0] * ts) % n
        c[1] = (c[1] + direction[td][1] * ts) % n

    # print(cloud)

    # 2. 구름 있는 곳 물의 양 +1
    for c in cloud:
        a[c[0]][c[1]] += 1

    # 4. 물이 증가한 칸에 대각선에 물이 있는 바구니 수 만큼 물의 양 +1
    for c in cloud:
        count = 0
        x, y = c[0], c[1]
        for j in diagonal:
            nx, ny = x + j[0], y + j[1]
            if 0<=nx<n and 0<=ny<n and a[nx][ny] > 0:
                count += 1
        a[x][y] += count

    cloud_set = set((x, y) for x, y in cloud)
    for p in range(n):
        for q in range(n):
            if (p, q) not in cloud_set and a[p][q] >= 2:
                new_cloud.append([p, q])
                a[p][q] -= 2

    # 3. 구름 사라짐
    cloud = []
    for nc in new_cloud:
        cloud.append(nc)
    new_cloud = []

    # for k in a:
    #     print(*k)

print(sum([sum(r) for r in a]))