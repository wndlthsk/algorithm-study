# 오답
# 정렬 시, 인접한 두 점은 변을 보장하지 않는다.

def solution(dots):
    min_x, max_x = float('inf'), float('-inf')
    min_y, max_y = float('inf'), float('-inf')
    
    for x, y in dots:
        min_x = min(min_x, x)
        max_x = max(max_x, x)
        min_y = min(min_y, y)
        max_y = max(max_y, y)
    
    width = max_x - min_x
    height = max_y - min_y
    
    return width * height