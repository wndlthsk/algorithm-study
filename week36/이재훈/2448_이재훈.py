def draw(n):
  if n == 3:
    return [
      "  *  ",
      " * * ",
      "*****"
    ]

  half = n // 2
  top = draw(half)
  bottom = draw(half)

  res = []

  # 1) 위쪽: 가운데 정렬
  for line in top:
    res.append(" " * (half) + line + " " * (half))

  # 2) 아래쪽: 양쪽에 붙이기
  for line1, line2 in zip(bottom, bottom):
    res.append(line1 + " " + line2)

  return res

N = int(input())
result = draw(N)
print("\n".join(result))
