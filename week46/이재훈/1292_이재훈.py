A, B = map(int, input().split())

arr = []
num = 1
while len(arr) < B:
  arr.extend([num] * num)
  num += 1
print(sum(arr[A-1:B]))