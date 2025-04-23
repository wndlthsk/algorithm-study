import sys
input=sys.stdin.readline
n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
arr = sorted(arr)
for a in arr:
    print(a)
