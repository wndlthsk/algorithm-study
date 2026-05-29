def solution(s, n):
    result = []

    for x in s:
        if x == ' ':
            result.append(' ')
        elif x.islower():
            result.append(chr((ord(x) - ord('a') + n) % 26 + ord('a')))
        else:
            result.append(chr((ord(x) - ord('A') + n) % 26 + ord('A')))

    return ''.join(result)