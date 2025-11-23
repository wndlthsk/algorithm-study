N, M = map(int, input().split())

# case 1: N == 1 → 이동 불가
if N == 1:
  print(1)
# case 2: N == 2 → 최대 4칸
elif N == 2:
  print(min(4, (M + 1) // 2))
# case 3: N >= 3
else:
  if M < 7:
    print(min(4, M))
  else:
    print(M - 2)
