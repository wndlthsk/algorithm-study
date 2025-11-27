def solution(distance, rocks, n):
    rocks.sort()
    rocks.append(distance)  # 도착지점도 한 '바위'로 처리

    left, right = 1, distance
    answer = 0

    while left <= right:
        mid = (left + right) // 2  # 후보 최소거리 D
        removed = 0
        prev = 0

        for rock in rocks:
            if rock - prev < mid:
                removed += 1  # 이 바위를 제거
            else:
                prev = rock  # 남김

        if removed > n:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1

    return answer
