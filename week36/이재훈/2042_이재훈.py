import sys
input = sys.stdin.readline

# 세그먼트 트리 초기화
def build(node, start, end):
  if start == end:
    tree[node] = arr[start]
    return tree[node]
  mid = (start + end) // 2
  left = build(node*2, start, mid)
  right = build(node*2+1, mid+1, end)
  tree[node] = left + right
  return tree[node]

# 특정 인덱스 값 수정
def update(node, start, end, idx, val):
  if idx < start or idx > end:
    return tree[node]
  if start == end:
    tree[node] = val
    return tree[node]
  mid = (start + end) // 2
  left = update(node*2, start, mid, idx, val)
  right = update(node*2+1, mid+1, end, idx, val)
  tree[node] = left + right
  return tree[node]

# 구간 합
def query(node, start, end, left, right):
  if right < start or end < left:
    return 0
  if left <= start and end <= right:
    return tree[node]
  mid = (start + end) // 2
  return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right)

N, M, K = map(int, input().split())
arr = [0] + [int(input()) for _ in range(N)]
tree = [0] * (4 * N)

build(1, 1, N)

for _ in range(M + K):
  a, b, c = map(int, input().split())
  
  if a == 1:  # update: b번째 수를 c로 변경
    update(1, 1, N, b, c)
    arr[b] = c
  else:       # query: b부터 c까지의 합 출력
    if b > c:
      b, c = c, b
    print(query(1, 1, N, b, c))
