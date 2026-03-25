import sys
input = sys.stdin.readline

S, E, Q = input().split()

def to_min(t):
  h, m = map(int, t.split(':'))
  return h * 60 + m

S = to_min(S)
E = to_min(E)
Q = to_min(Q)

enter = set()
answer = set()

while True:
  line = input().strip()
  if not line:
    break
  t, name = line.split()
  t = to_min(t)

  if t <= S:
    enter.add(name)
  elif E <= t <= Q:
    if name in enter:
      answer.add(name)

print(len(answer))