import sys

N = int(sys.stdin.readline())

x, y, z = map(int, sys.stdin.readline().split())
max_row = [x, y, z]
min_row = [x, y, z]

for _ in range(1, N):
    x, y, z = map(int, sys.stdin.readline().split())

    a, b, c = max_row
    d, e, f = min_row

    max_row[0] = x + max(a, b)
    min_row[0] = x + min(d, e)

    max_row[1] = y + max(a, b, c)
    min_row[1] = y + min(d, e, f)

    max_row[2] = z + max(b, c)
    min_row[2] = z + min(e, f)
    # print(max_row)
    # print(min_row)

print(max(max_row), min(min_row))