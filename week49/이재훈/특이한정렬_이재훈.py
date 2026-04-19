def solution(numlist, n):
    # 1. 각 원소를 (거리, 값) 형태로 변환
    arr = []
    for x in numlist:
        dist = abs(x - n)
        arr.append((dist, x))
    
    # 2. 정렬 기준 정의
    # 거리 오름차순, 값 내림차순
    arr.sort(key=lambda x: (x[0], -x[1]))
    
    # 3. 값만 추출
    result = []
    for _, value in arr:
        result.append(value)
    
    return result