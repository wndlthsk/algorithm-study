def count_digits_dp(N):
    digits = len(str(N))
    length = 0
    prev = 1
    
    for i in range(1, digits):
        next_val = prev * 10
        length += (next_val - prev) * i
        prev = next_val
    
    length += (N - prev + 1) * digits
    
    return length

N = int(input())
print(count_digits_dp(N))