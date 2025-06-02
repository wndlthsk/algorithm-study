n = int(input())
seq = list(map(int, input().split()))

no_delete_dp = [0] * (n + 1)
no_delete_dp[1] = seq[0] # 초기화 필수. LIS 부분합 문제에서 -inf 케이스 고려.

yes_delete_dp = [0] * (n + 1)
yes_delete_dp[1] = seq[0] # 굳이 필요없지만 안정성을 위한 초기화.

for i in range(2, n + 1):
  no_delete_dp[i] = max(no_delete_dp[i - 1] + seq[i - 1], seq[i - 1])
  yes_delete_dp[i] = max(yes_delete_dp[i - 1] + seq[i - 1], no_delete_dp[i - 1])
print(max(max(no_delete_dp[1:]), max(yes_delete_dp[1:])))

# yes_delete_dp[i] = max(yes_delete_dp[i], yes_delete_dp[i - 1] + seq[i - 1])가 아닌이유
# 제거 시점은 딱 1번만 가능 → yes_delete_dp는 "이미 삭제 1번 쓴 상태"를 관리.

# ① 이전에 이미 삭제 쓴 상태에서 그냥 이번 원소 포함시키는 경우
# yes_delete_dp[i - 1] + seq[i - 1]
# ② 이번에 처음 삭제를 쓰는 경우 → "이번 원소 삭제!" (= i-1번째까지 삭제 안 한 상태에서 건너뜀)
# no_delete_dp[i - 1]
# 따라서 yes_delete_dp[i] = max(yes_delete_dp[i - 1] + seq[i - 1], no_delete_dp[i - 1]) 성립함.
