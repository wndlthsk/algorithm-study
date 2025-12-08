import sys
input = sys.stdin.readline

N = int(input())

stk = []
dic = {
  1: lambda x: stk.append(x),
  2: lambda: stk.pop() if stk else -1,
  3: lambda: len(stk),
  4: lambda: 1 if not stk else 0,
  5: lambda: stk[-1] if stk else -1,
}

for _ in range(N):
    line = input().split()
    cmd = int(line[0])

    if cmd == 1:
        dic[1](line[1])  # push
    else:
        print(dic[cmd]())
