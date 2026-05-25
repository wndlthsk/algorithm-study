def solution(arr1, arr2):
    res = []
    for iter_a1, iter_a2 in zip(arr1, arr2):
        row = []
        for a1, a2 in zip(iter_a1, iter_a2):
            row.append(a1 + a2)
        res.append(row)
    
    return res