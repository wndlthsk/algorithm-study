import sys
input = sys.stdin.readline

def build_tree(n):
  # tree 배열 초기화
  size = 1
  while size < n:
    size *= 2
  tree = [0] * (2 * size)
  for i in range(n):
    tree[size + i] = 1  # 사람 살아있음
  for i in range(size-1, 0, -1):
    tree[i] = tree[i*2] + tree[i*2+1]
  return tree, size

def query(tree, size, k):
  # k번째 살아있는 사람 찾기
  i = 1
  while i < size:
    if tree[i*2] >= k:
      i = i*2
    else:
      k -= tree[i*2]
      i = i*2 + 1
  return i - size # 0-based index

def update(tree, size, idx):
  # idx 위치 사람 제거
  i = idx + size
  tree[i] = 0
  while i > 1:
    i //= 2
    tree[i] = tree[i*2] + tree[i*2+1]

N, K = map(int, input().split())
tree, size = build_tree(N)
res = []
idx = 0

for i in range(N):
  remaining = N - i
  idx = (idx + K - 1) % remaining
  person = query(tree, size, idx + 1)  # query는 1-based k 사용
  res.append(person + 1)  # 사람 번호는 1-based
  update(tree, size, person)

sys.stdout.write("<" + ", ".join(map(str, res)) + ">\n")
