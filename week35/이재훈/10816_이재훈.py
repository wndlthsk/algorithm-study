N = int(input())
exist = sorted(map(int, input().split()))
M = int(input())
should_find = list(map(int, input().split()))

def lower_bound(target):
  start, end = 0, len(exist)
  while start < end:
    mid = (start + end) // 2
    if exist[mid] >= target:
      end = mid
    else:
      start = mid + 1
  return start

def upper_bound(target):
  start, end = 0, len(exist)
  while start < end:
    mid = (start + end) // 2
    if exist[mid] > target:
      end = mid
    else:
      start = mid + 1
  return start

def get_cards_num(num):
  return upper_bound(num) - lower_bound(num)

for x in should_find:
  print(get_cards_num(x), end=' ')