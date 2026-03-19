nums = list(map(int, input().split()))

# 시계수 구하기
def get_clock(arr):
  candidates = []
  for i in range(4):
    rotated = arr[i:] + arr[:i]
    candidates.append(int(''.join(map(str, rotated))))
  return min(candidates)

target = get_clock(nums)

count = 0
for i in range(1111, 10000):
  s = str(i)
  if '0' in s:
    continue
  
  arr = list(map(int, s))
  if get_clock(arr) == i:
    count += 1
    if i == target:
      print(count)
      break