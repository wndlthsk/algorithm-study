n = int(input())
op_lst = input().split()

results = []

def is_valid(a, b, op):
  if op == '<':
    return a < b
  else:
    return a > b

def dfs(depth, path, used):
  if depth == n + 1:
    results.append(''.join(map(str, path)))
    return

  for i in range(10):
    if used[i]:
      continue

    if depth == 0 or is_valid(path[-1], i, op_lst[depth - 1]):
      used[i] = True
      dfs(depth + 1, path + [i], used)
      used[i] = False

used = [False] * 10
dfs(0, [], used)

results.sort()
print(results[-1])  # 최대값
print(results[0])   # 최소값
