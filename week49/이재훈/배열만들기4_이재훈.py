def solution(arr):
    stk = []
    i = 0
    while i < len(arr):
        target = arr[i]
        if not stk:
            stk.append(target)
            i += 1
            continue
        
        if stk[-1] < target:
            stk.append(target)
            i += 1
        else:
            stk.pop()
        
    return stk