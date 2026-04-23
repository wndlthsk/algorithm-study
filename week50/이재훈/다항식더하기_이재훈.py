def solution(polynomial):
    poly = polynomial.split(' + ')
    
    first = 0
    second = 0
    for x in poly:
        if 'x' in x:
            f = x.rstrip('x')
            first += int(1 if f == '' else f)
        else:
            second += int(x)
    
    res = ""
    if first == 1:
        first = ''
    
    if first != 0 and second == 0:
        res = f"{first}x"
    elif first == 0 and second != 0:
        res = f"{second}"
    else:
        res = f"{first}x + {second}"
    
    return res