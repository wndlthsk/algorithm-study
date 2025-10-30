import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

class MergeKth:
  def __init__(self, A, K):
    self.A = A
    self.K = K
    self.tmp = [0] * len(A)
    self.cnt = 0
    self.snap = None   # K번째 저장 직후 배열 스냅샷
    self.found = False # 스냅샷 저장 여부

  def copy_back_and_count(self, p, r):
    A, tmp = self.A, self.tmp
    for i in range(p, r + 1):
      A[i] = tmp[i]
      self.cnt += 1
      if not self.found and self.cnt == self.K:
        self.snap = A[:]   # K번째 저장 '직후' 상태 전체 복사
        self.found = True

  def merge(self, p, q, r):
    A, tmp = self.A, self.tmp
    i, j, t = p, q + 1, p
    while i <= q and j <= r:
      if A[i] <= A[j]:
        tmp[t] = A[i]; i += 1
      else:
        tmp[t] = A[j]; j += 1
      t += 1
    while i <= q:
      tmp[t] = A[i]; i += 1; t += 1
    while j <= r:
      tmp[t] = A[j]; j += 1; t += 1

    self.copy_back_and_count(p, r)

  def merge_sort(self, p, r):
    if p >= r:
      return
    q = (p + r) // 2
    self.merge_sort(p, q)
    self.merge_sort(q + 1, r)
    self.merge(p, q, r)

N, K = map(int, input().split())
Ai = list(map(int, input().split()))

solver = MergeKth(Ai, K)
solver.merge_sort(0, N - 1)

if solver.found:
  print(*solver.snap)
else:
  print(-1)
