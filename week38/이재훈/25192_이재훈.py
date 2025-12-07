N = int(input())
seen = set()
cnt = 0

for _ in range(N):
  s = input()
  if s == 'ENTER':
    seen.clear()      # 새로운 세션 시작
    continue
  if s not in seen:     # 세션 내에서 처음 본 닉네임만 카운트
    cnt += 1
    seen.add(s)
print(cnt)