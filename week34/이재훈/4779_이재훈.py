import sys

def cantor(arr, l, r):
  length = r - l
  if length < 3:
    return
  third = length // 3
  # 가운데 1/3을 공백으로
  arr[l + third : l + 2*third] = [' '] * third
  # 좌/우 1/3에 재귀
  cantor(arr, l, l + third)
  cantor(arr, l + 2*third, r)

for line in sys.stdin:
  line = line.strip()
  if not line:
    continue
  N = int(line)
  L = 3 ** N
  arr = ['-'] * L
  cantor(arr, 0, L)
  print(''.join(arr))