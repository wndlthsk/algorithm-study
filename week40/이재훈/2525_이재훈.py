A, B = map(int, input().split())
C = int(input())

current_min = A * 60 + B

total = (current_min + C) % (24 * 60)
h = total // 60
m = total - (h * 60)
print(h, m)