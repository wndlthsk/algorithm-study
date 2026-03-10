import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
  s = input().strip()
  
  if (
    len(s) == 7 and
    s[0] == s[1] == s[4] and
    s[2] == s[3] == s[5] == s[6] and
    s[0] != s[2]
  ):
    print(1)
  else:
    print(0)