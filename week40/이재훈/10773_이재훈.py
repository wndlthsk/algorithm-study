K = int(input())
numbers = []
for _ in range(K):
  n = input()
  if n == '0':
    numbers.pop()
  else:
    numbers.append(int(n))
print(sum(numbers))