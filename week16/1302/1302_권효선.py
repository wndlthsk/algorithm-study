import sys
input = sys.stdin.readline  # 빠른 입력

n = int(input())
d = dict()

for i in range(n):
    book = input().strip()  # 꼭 .strip() 해줘야 함
    if book in d:
        d[book] += 1
    else:
        d[book] = 1

m = max(d.values())

best = []
for k, v in d.items():
    if m == v:
        best.append(k)

best.sort()
print(best[0])
