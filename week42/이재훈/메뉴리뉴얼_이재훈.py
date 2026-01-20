from itertools import combinations

def solution(orders, course):
  answer = []

  for cnt in course:
    freq = {}

    for order in orders:
      order = sorted(order)
      for c in combinations(order, cnt):
        freq[c] = freq.get(c, 0) + 1

    if not freq:
      continue

    max_cnt = max(freq.values())
    if max_cnt < 2:
      continue

    for k, v in freq.items():
      if v == max_cnt:
        answer.append(''.join(k))

  return sorted(answer)
