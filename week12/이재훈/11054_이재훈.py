N = int(input())
Ai = list(map(int, input().split()))

# 증가 부분 수열 DP
dp_increase = [1] * (N + 1)
for i in range(1, N + 1):
    for j in range(1, i):
        if Ai[j - 1] < Ai[i - 1]:
            dp_increase[i] = max(dp_increase[i], dp_increase[j] + 1)

# 감소 부분 수열 DP
dp_decrease = [1] * (N + 1)
for i in range(N, 0, -1):
    for j in range(N, i, -1):
        if Ai[j - 1] < Ai[i - 1]:
            dp_decrease[i] = max(dp_decrease[i], dp_decrease[j] + 1)

# 가장 긴 바이토닉 부분 수열의 길이 구하기
max_length = 0
for i in range(1, N + 1):
    max_length = max(max_length, dp_increase[i] + dp_decrease[i] - 1)
print(max_length)


# dp_increase / dp_decrease 두 번 dp 사용
# → 마지막에 i마다 dp_increase[i] + dp_decrease[i] - 1 계산
# "LIS + 역방향 LIS" 두 번하는 문제.