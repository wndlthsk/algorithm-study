def solution(n, w, num):
    # num의 row, col
    r = (num - 1) // w
    c = (num - 1) % w
    
    # 지그재그 보정
    if r % 2 == 1:
        c = w - 1 - c
    
    answer = 1  # 자기 자신 포함
    
    # 위 row들 확인
    for nr in range(r + 1, (n - 1) // w + 1):
        # 해당 row의 col 계산
        if nr % 2 == 0:
            nc = c
        else:
            nc = w - 1 - c
        
        # 실제 번호 계산
        box = nr * w + nc + 1
        
        if box <= n:
            answer += 1
    
    return answer