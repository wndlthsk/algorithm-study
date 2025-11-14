def dp_line(arr):
    n = len(arr)
    dp = [0] * (n + 1)
    dp[1] = arr[0]
    if n >= 2:
        dp[2] = max(arr[0], arr[1])
    for i in range(3, n + 1):
        dp[i] = max(dp[i-1], dp[i-2] + arr[i-1])
    return dp[n]

def solution(sticker):
    N = len(sticker)
    if N == 1:
        return sticker[0]

    # 첫 스티커 선택: 마지막 스티커 제외
    case1 = dp_line(sticker[:-1])
    # 첫 스티커 미선택: 마지막 스티커 포함 가능
    case2 = dp_line(sticker[1:])

    return max(case1, case2)
