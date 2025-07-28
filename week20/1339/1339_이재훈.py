N = int(input())
words = [input() for _ in range(N)]

weight = {}

for word in words:
  digit = 1  # 일의 자리부터 시작
  for char in reversed(word):  # 뒤에서부터 순회 (일의 자리부터 시작)
    if char in weight:
      weight[char] += digit
    else:
      weight[char] = digit
    digit *= 10  # 다음은 십의 자리, 백의 자리, ...

# 가중치 내림차순 정렬
sorted_weights = sorted(weight.items(), key=lambda x: x[1], reverse=True)

# 알파벳에 숫자 할당
num = 9
total = 0
for char, w in sorted_weights:
  total += w * num
  num -= 1
print(total)