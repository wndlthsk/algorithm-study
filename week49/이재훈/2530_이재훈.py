A, B, C = map(int, input().split())
D = int(input())

H, M, S = 24, 60, 60

A = A + (D // H) % H
D %= H
B = B + (D // M) % M
D %= M
C = C + (D // S) % S

print(A, B, C)