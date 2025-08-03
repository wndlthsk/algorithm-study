N = int(input())

weights = list(map(int, input().split()))

max_energy = 0
def dfs(arr, total):
  global max_energy

  if len(arr) == 2:
    max_energy = max(max_energy, total)
    return

  for i in range(1, len(arr) - 1):
    gain = arr[i - 1] * arr[i + 1]
    removed = arr.pop(i)
    dfs(arr, total + gain)
    arr.insert(i, removed)
dfs(weights, 0)
print(max_energy)