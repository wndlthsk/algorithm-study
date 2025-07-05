CURRENT = 100
KEY = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

N = int(input())
num_broken = int(input())
if num_broken > 0:
  broken_key = list(map(int, input().split()))
else:
  broken_key = []

possible_key = [x for x in KEY if x not in broken_key]

# 방법 1: + - 만 사용하는 경우 (기본값)
min_click = abs(N - CURRENT)

# 방법 2: 모든 가능한 숫자 조합을 만들어서 비교
# 1자리 ~ 6자리까지 모든 조합 시도
for length in range(1, 7):
    channels = ['']  # 시작은 빈 문자열

    # 각 자리에 숫자 추가 (중첩 반복문처럼 구현)
    for _ in range(length):
        equal_length_level_channels = []
        for prefix in channels:
            for p_key in possible_key:
                equal_length_level_channels.append(prefix + str(p_key))
        channels = equal_length_level_channels  # 갱신

    # 완성된 숫자 조합들을 channels에 추가
    for s in channels:
        channel = int(s)
        press_count = len(s) + abs(N - channel)
        min_click = min(min_click, press_count)

print(min_click)

# 반복 횟수   channels 내용
# 초기	      ['']
# 1번째 반복	['1', '2']
# 2번째 반복	['11', '12', '21', '22']
# 3번째 반복	['111', '112', '121', '122', '211', '212', '221', '222']