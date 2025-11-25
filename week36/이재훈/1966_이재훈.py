from collections import deque

T = int(input())

for _ in range(T):
  N, M = map(int, input().split())
  weights = list(map(int, input().split()))

  # (문서번호, 중요도)
  q = deque((i, w) for i, w in enumerate(weights))

  count = 0

  while q:
    idx, w = q[0]

    # 가장 큰 중요도인지 확인
    if w == max(weights):
      # 출력
      count += 1
      q.popleft()
      weights.remove(w)

      if idx == M:
        print(count)
        break

    else:
      # 중요도 낮으면 뒤로 보냄
      q.rotate(-1)