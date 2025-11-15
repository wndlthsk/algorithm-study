N = int(input())
exist = sorted(map(int, input().split()))
M = int(input())
should_find = list(map(int, input().split()))

def binary_search(target):
  start, end = 0, len(exist) - 1
  
  while start <= end:
    mid = (start + end) // 2
    
    if exist[mid] == target:
      return 1
    elif exist[mid] < target:
      start = mid + 1
    else:
      end = mid - 1
  
  return 0

for x in should_find:
  print(binary_search(x), end=' ')
