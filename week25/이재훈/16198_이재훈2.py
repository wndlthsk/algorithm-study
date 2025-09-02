N = int(input())
balls = list(map(int, input().split()))

max_energy = 0
def dfs(arr, energy):
  global max_energy
  if len(arr) == 2:
    max_energy = max(max_energy, energy)
    return
  
  for i in range(1, len(arr) - 1):
    val = arr[i - 1] * arr[i + 1]
    poped = arr.pop(i)
    dfs(arr, energy + val)
    arr.insert(i, poped)

dfs(balls[:], 0)
print(max_energy)