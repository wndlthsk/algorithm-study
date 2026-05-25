def solution(number, limit, power):
    def get_cnt_divisor(num):
        if num <= 1:
            return 1
        
        cnt = 2
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                if i == num // i:
                    cnt += 1
                else:
                    cnt += 2
        
        return cnt
    
    cnts = [0] * number
    for i in range(number):
        cnts[i] = get_cnt_divisor(i+1)
        if cnts[i] > limit:
            cnts[i] = power
    
    return sum(cnts)