A, B = map(int, input().split())

step = 1
cnt = 0
seq = []
while len(seq) < B:
  if cnt >= step:
    cnt = 0
    step += 1
  seq.append(step)
  cnt += 1
print(sum(seq[A-1:B]))