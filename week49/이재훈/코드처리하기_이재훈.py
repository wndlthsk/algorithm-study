# 문자열 읽기만 할 때는 list변환 필요 없음

def solution(code):
    mode = 0
    ret = []
    for idx, v in enumerate(code):
        if v == '1':
            mode = 1 - mode
            continue
        
        if mode == 0:
            if idx % 2 == 0:
                ret.append(v)
        elif mode == 1:
            if idx % 2 != 0:
                ret.append(v)
    
    return ''.join(ret) if ret else 'EMPTY'