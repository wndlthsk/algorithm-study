def solution(balls, share):
    if balls - share < share:
        share = balls - share
    
    top = 1
    for i in range(balls, balls - share, -1):
        top *= i
    
    bottom = 1    
    for i in range(share, 0, -1):
        bottom *= i
    
    return top // bottom