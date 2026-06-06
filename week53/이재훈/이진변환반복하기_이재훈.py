def solution(s):
    count = 0
    removed = 0

    while s != "1":
        removed += s.count("0")
        s = bin(s.count("1"))[2:]
        count += 1

    return [count, removed]