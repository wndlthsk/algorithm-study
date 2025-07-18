n = int(input())
arr = list(map(int, input().split()))
op_num = list(map(int, input().split())) 

max_ans =-999999999999999
min_ans = 999999999999999

def calc(a, b):
    if a * b > 0:
        return int(a / b)
    else:
        return -(-a // b)

op_funcs = [
    lambda a, b: a + b,
    lambda a, b: a - b,
    lambda a, b: a * b,
    calc
]

def dfs(idx, result, op_num):
    global max_ans, min_ans
    if idx == n:
        max_ans = max(max_ans, result)
        min_ans = min(min_ans, result)
        return
    for i in range(4):
        if op_num[i]:
            new_ops = op_num[:]
            new_ops[i] -= 1
            dfs(idx + 1, op_funcs[i](result, arr[idx]), new_ops)

dfs(1, arr[0], op_num)
print(max_ans)
print(min_ans)
