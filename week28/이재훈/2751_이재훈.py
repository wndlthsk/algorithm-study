import sys
N = int(sys.stdin.readline())
lst = [int(sys.stdin.readline()) for _ in range(N)]

lst.sort()
print("\n".join(map(str, lst)))
