def solution(number, limit, power):
    answer = 0

    for num in range(1, number + 1):
        count = 0

        for i in range(1, int(num ** 0.5) + 1):
            if num % i == 0:
                count += 1

                if i != num // i:
                    count += 1

        if count > limit:
            answer += power
        else:
            answer += count

    return answer