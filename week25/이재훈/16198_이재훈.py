N = int(input())
Wi = list(map(int, input().split()))

max_energy = 0
def dfs(arr, energy):
  global max_energy
  if len(arr) == 2:
    max_energy = max(max_energy, energy)
    return
  
  for i in range(1, len(arr) - 1):
    val = Wi[i-1] * Wi[i+1]
    removed = arr.pop(i)
    del Wi[i]
    dfs(arr, energy + val)
    arr.insert(i, removed)
dfs(Wi, 0)
print(max_energy)