import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
num = list(map(int, data[1:N+1]))
M = int(data[N+1])
queries = data[N+2:]

# 0-based indexing
dp = [[False] * N for _ in range(N)] # 구간 [s, e]에 대해 팰린드롬 여부

# 길이 1 (자기 자신): 항상 팰린드롬
for i in range(N):
  dp[i][i] = True

# 길이 2
for i in range(N - 1):
  if num[i] == num[i + 1]:
    dp[i][i + 1] = True

# 길이 3 이상
for length in range(3, N + 1):  # length는 구간 길이
  for start in range(N - length + 1): # 길이의 부분 수열이 시작하는 인덱스
    end = start + length - 1 # 길이의 마지막 인덱스
    if num[start] == num[end] and dp[start + 1][end - 1]: # 양 끝 숫자가 같고, 안쪽도 팰린드롬이면 전체도 팰린드롬
      dp[start][end] = True

# 쿼리 처리
output = []
for i in range(0, 2 * M, 2):
  s = int(queries[i]) - 1
  e = int(queries[i + 1]) - 1
  output.append('1' if dp[s][e] else '0')
print('\n'.join(output))
