def solution(n):
    answer = 0

    for start in range(1, n + 1):
        total = 0

        for num in range(start, n + 1):
            total += num

            if total == n:
                answer += 1
                break

            if total > n:
                break

    return answer