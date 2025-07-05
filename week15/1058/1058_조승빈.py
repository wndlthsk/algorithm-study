n = int(input())
arr = []
ans = 0
for _ in range(n):
    arr.append(list(input()))
for i in range(n):
    vis = set()
    for j in range(n):
        if i == j:
            continue
        if arr[i][j] == 'Y':
            vis.add(j)
        else:
            for k in range(n):
                if arr[i][k] == 'Y' and arr[k][j] == 'Y':
                    vis.add(j)
                    break
    ans = max(ans, len(vis))

print(ans)
