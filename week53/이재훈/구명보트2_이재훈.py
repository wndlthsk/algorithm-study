def solution(people, limit):
    srt = sorted(people)

    cnt = 0
    left, right = 0, len(srt) - 1
    while left <= right:
        big = srt[right]
        small = srt[left]
        
        right -= 1
        if big + small <= limit:
            left += 1
        
        cnt += 1

    return cnt