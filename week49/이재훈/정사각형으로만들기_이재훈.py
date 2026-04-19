def solution(arr):
    row_cnt = len(arr)
    col_cnt = max(len(arr[r]) for r in range(row_cnt))
    
    if row_cnt > col_cnt:
        for r in range(row_cnt):
            need_more = row_cnt - len(arr[r])
            arr[r] = arr[r] + [0] * need_more
    elif row_cnt < col_cnt:
        for _ in range(col_cnt - row_cnt):
            empty_arr = [0] * col_cnt
            arr.append(empty_arr)
    
    return arr