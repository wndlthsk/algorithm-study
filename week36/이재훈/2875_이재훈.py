N, M, K = map(int, input().split())

# 팀 개수는 여자 2명 + 남자 1명 조건
team = min(N // 2, M)

# 팀을 만들 수 있는 상태에서 K명 제거 필요
# 팀을 만들기 위해 필요한 최소 인원은 team*3 명
# 전체 인원은 N + M
# 남는 인원 = (전체 인원 - 필요한 인원)
remain = N + M - team * 3

# 남는 인원으로 K명을 커버 못하면 팀을 줄여야 함
if remain < K:
  # 부족한 만큼 팀을 깎아야 함 (팀 하나 깎으면 3명 확보)
  need = K - remain
  team -= (need + 2) // 3   # 올림 나눗셈

print(team)
