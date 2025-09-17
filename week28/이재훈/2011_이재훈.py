code = input().rstrip()
MOD = 1_000_000
n = len(code)

dp = [0] * (n + 1)
dp[0] = 1  # 초기값: 아무것도 해석하지 않은 경우

for i in range(1, n + 1):
  # 1자리 숫자 (1~9)
  if code[i - 1] != '0':  
    dp[i] += dp[i - 1]

  # 2자리 숫자 (10~26)
  if i >= 2:
    num = int(code[i - 2:i])
    if 10 <= num <= 26:
      dp[i] += dp[i - 2]

  dp[i] %= MOD
print(dp[n])