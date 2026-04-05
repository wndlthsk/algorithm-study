import sys
input = sys.stdin.readline

X, Y, W, S = map(int, input().split())

case1 = (X + Y) * W
case2 = min(X, Y) * S + (max(X, Y) - min(X, Y)) * W

if (X + Y) % 2 == 0:
  case3 = max(X, Y) * S
else:
  case3 = (max(X, Y) - 1) * S + W
print(min(case1, case2, case3))