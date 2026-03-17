cards = [input().split() for _ in range(5)]

# 색 / 숫자 분리
colors = [c for c, n in cards]
numbers = sorted([int(n) for c, n in cards])

# 같은 색인지
is_same_color = all(colors[0] == color for color in colors)

# 스트레이트인지
is_straight = True
for i in range(4):
  if numbers[i] + 1 != numbers[i + 1]:
    is_straight = False
    break

# 숫자 빈도
freq_map = {}
for num in numbers:
  freq_map[num] = freq_map.get(num, 0) + 1

# 빈도 리스트
freq = sorted(freq_map.values(), reverse=True)

# (개수, 숫자) 기준 정렬
num_by_count = sorted(freq_map.items(), key=lambda x: (-x[1], -x[0]))

# 판별
if is_same_color and is_straight:
  print(900 + numbers[-1])
elif freq[0] == 4:
  print(800 + num_by_count[0][0])
elif freq[0] == 3 and freq[1] == 2:
  print(700 + num_by_count[0][0] * 10 + num_by_count[1][0])
elif is_same_color:
  print(600 + numbers[-1])
elif is_straight:
  print(500 + numbers[-1])
elif freq[0] == 3:
  print(400 + num_by_count[0][0])
elif freq[0] == 2 and freq[1] == 2:
  print(300 + num_by_count[0][0] * 10 + num_by_count[1][0])
elif freq[0] == 2:
  print(200 + num_by_count[0][0])
else:
  print(100 + numbers[-1])