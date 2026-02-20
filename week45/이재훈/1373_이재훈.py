binary = input()
n = len(binary)

# 길이를 3의 배수로 맞추기 위해 앞에 0을 채움
pad = (3 - n % 3) % 3
binary = '0' * pad + binary

res = []
for i in range(0, n, 3):
  chunk = binary[i:i+3]
  digit = 0
  for j in range(3):
    if chunk[j] == '1':
      digit += 2 ** (2 - j)
  res.append(str(digit))
print(''.join(res))