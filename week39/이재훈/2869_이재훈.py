A, B, V = map(int, input().split())

# 이미 첫 날에 도착 가능한 경우
if V <= A:
  print(1)
else:
  V -= A          # 마지막 날에 올라갈 높이를 미리 빼줌
  daily = A - B   # 하루 순 상승량

  days = V // daily
  if V % daily != 0:
    days += 1

  print(days + 1)  # 마지막 날
