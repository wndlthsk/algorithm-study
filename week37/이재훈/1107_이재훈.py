N = int(input())
M = int(input())
if M > 0:
  broken = set(map(int, input().split()))
else:
  broken = set()

# 1) +,- 만 눌러서 이동
ans = abs(N - 100)

# 2) 숫자 버튼으로 만들 수 있는 모든 번호 탐색
def can_make(num):
  for ch in str(num):
    if int(ch) in broken:
      return False
  return True

# 숫자의 범위를 넉넉히 잡아도 됨
for num in range(1000000):  # 0 ~ 999,999
  if can_make(num):
    # 숫자 입력 횟수
    press = len(str(num))
    # 이후 +,- 이동
    press += abs(num - N)
    ans = min(ans, press)
print(ans)